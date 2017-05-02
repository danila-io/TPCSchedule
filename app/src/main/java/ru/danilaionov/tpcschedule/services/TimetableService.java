package ru.danilaionov.tpcschedule.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.danilaionov.tpcschedule.models.Group;
import ru.danilaionov.tpcschedule.models.Schedule;

/**
 * Created by danilaionov on 03/04/2017.
 */

public interface TimetableService {

    @GET("group")
    Call<List<Group>> getGroups();

    @GET("group/{id}/schedule")
    Call<List<Schedule>> getSchedule(@Path("id") int groupId);

}
