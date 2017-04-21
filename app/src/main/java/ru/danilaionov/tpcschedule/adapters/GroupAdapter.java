package ru.danilaionov.tpcschedule.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.danilaionov.tpcschedule.R;
import ru.danilaionov.tpcschedule.models.Group;

/**
 * Created by danilaionov on 04/04/2017.
 */

public class GroupAdapter extends ArrayAdapter<Group> {

    public GroupAdapter(Context context, List<Group> groups) {
        super(context, 0, groups);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Group group = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.group_item, parent, false);
        }
        // Lookup view for data population
        TextView groupName = (TextView) convertView.findViewById(R.id.group_name);
        // Populate the date into the template view using the data object
        groupName.setText(group.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
