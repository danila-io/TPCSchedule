package ru.danilaionov.tpcschedule.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.danilaionov.tpcschedule.R;

/**
 * Created by danilaionov on 16/05/2017.
 */

public class LessonViewHolder extends RecyclerView.ViewHolder {

    private TextView number;
    private TextView name;

    public LessonViewHolder(View itemView) {
        super(itemView);

        number = (TextView) itemView.findViewById(R.id.lessonNumber);
        name = (TextView) itemView.findViewById(R.id.lessonName);
    }

    public TextView getNumber() {
        return number;
    }

    public void setNumber(TextView number) {
        this.number = number;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }
}
