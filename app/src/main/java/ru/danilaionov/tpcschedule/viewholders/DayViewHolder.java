package ru.danilaionov.tpcschedule.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.danilaionov.tpcschedule.R;
import ru.danilaionov.tpcschedule.adapters.LessonTileAdapter;
import ru.danilaionov.tpcschedule.models.Day;
import ru.danilaionov.tpcschedule.utils.DateUtils;
import ru.danilaionov.tpcschedule.views.InnerRecyclerLayoutManager;

/**
 * Created by danilaionov on 10/05/2017.
 */

public class DayViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    private LinearLayout header;
    private TextView dayOfWeek;
    private TextView date;
    private RecyclerView lessonsList;

    private Day day;

    public DayViewHolder(Context context, View itemView)
    {
        super(itemView);

        this.context = context;

        header = (LinearLayout) itemView.findViewById(R.id.day_header);
        dayOfWeek = (TextView) itemView.findViewById(R.id.day_week);
        date = (TextView) itemView.findViewById(R.id.day_date);

        lessonsList = (RecyclerView) itemView.findViewById(R.id.lessonsList);
    }

    public TextView getDate()
    {
        return date;
    }

    public void setDate(TextView date)
    {
        this.date = date;
    }

    public Day getDay()
    {
        return day;
    }

    public void setDay(Day day) throws ParseException {

        this.day = day;
        //this.date.setText(DateUtils.getDateShort());

        //Date date = DateUtils.toDate(day.getDate());
        //int colorId = DateUtils.isToday(date) ? R.color.colorAccent : R.color.colorPrimary;
        //header.setBackgroundColor(context.getResources().getColor(colorId));

        //this.dayOfWeek.setText(DateUtils.getDayOfWeek());
        this.dayOfWeek.setText(DateUtils.getDayOfWeek(day.getNumber()));

        lessonsList.setLayoutManager(new InnerRecyclerLayoutManager(context));
        lessonsList.setAdapter(new LessonTileAdapter(context, day.getLessons()));

    }


}
