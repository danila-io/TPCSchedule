package ru.danilaionov.tpcschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.danilaionov.tpcschedule.adapters.GroupAdapter;
import ru.danilaionov.tpcschedule.models.Group;
import ru.danilaionov.tpcschedule.services.TimetableServiceProvider;

/**
 * Created by danilaionov on 02/04/2017.
 */

public class GroupActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        final GroupActivity groupActivity = this;
        final ListView listView = (ListView) findViewById(R.id.group_list_view);

        TimetableServiceProvider.getService().getGroups().enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                List<Group> groups = response.body();
                GroupAdapter groupArrayAdapter = new GroupAdapter(groupActivity, groups);

                listView.setAdapter(groupArrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {

                Toast noConnectionMessage = Toast.makeText(groupActivity, R.string.connection_error, Toast.LENGTH_LONG);
                noConnectionMessage.setGravity(Gravity.CENTER, 0, 0);
                noConnectionMessage.show();
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String item = ((TextView)view).getText().toString();
//
//                Toast.makeText(groupActivity, item, Toast.LENGTH_LONG).show();
//
//            }
//        });
    }
}
