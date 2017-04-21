package ru.danilaionov.tpcschedule.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.danilaionov.tpcschedule.models.Group;

/**
 * Created by danilaionov on 03/04/2017.
 */

public interface TimetableService {

    @GET("group")
    Call<List<Group>> getGroups();

}
