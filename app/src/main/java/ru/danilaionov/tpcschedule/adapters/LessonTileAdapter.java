package ru.danilaionov.tpcschedule.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.danilaionov.tpcschedule.R;
import ru.danilaionov.tpcschedule.models.Lesson;
import ru.danilaionov.tpcschedule.viewholders.LessonViewHolder;

/**
 * Created by danilaionov on 16/05/2017.
 */

public class LessonTileAdapter extends RecyclerView.Adapter<LessonViewHolder> {

    private Context context;

    private List<Lesson> lessons;

    public LessonTileAdapter(Context context, List<Lesson> lessons)
    {
        this.context = context;
        this.lessons = lessons;
    }

    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lesson_tile, parent, false);

        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LessonViewHolder holder, int position)
    {
        Lesson lesson = lessons.get(position);

        holder.getNumber().setText(Integer.toString(lesson.getNumber()));
        holder.getName().setText(lesson.getName());
    }

    @Override
    public int getItemCount()
    {
        return lessons.size();
    }

    public void reloadData(List<Lesson> lessons)
    {
        this.lessons = lessons;
        notifyDataSetChanged();
    }
}
