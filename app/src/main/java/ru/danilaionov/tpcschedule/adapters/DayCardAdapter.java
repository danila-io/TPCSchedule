package ru.danilaionov.tpcschedule.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;

import ru.danilaionov.tpcschedule.R;
import ru.danilaionov.tpcschedule.models.Day;
import ru.danilaionov.tpcschedule.viewholders.DayViewHolder;

/**
 * Created by danilaionov on 11/05/2017.
 */

public class DayCardAdapter extends RecyclerView.Adapter<DayViewHolder> {

    private Context context;

    private List<Day> days;

    public DayCardAdapter(Context context, List<Day> days)
    {
        this.context = context;
        this.days = days;
    }

    public void reloadData(List<Day> days)
    {
        this.days = days;
        notifyDataSetChanged();
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_day, parent, false);

        return new DayViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        try {
            holder.setDay(days.get(position));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }
}
