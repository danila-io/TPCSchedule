package ru.danilaionov.tpcschedule.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danilaionov on 03/04/2017.
 */

public class TimetableServiceProvider {

    private static TimetableService service;

    private TimetableServiceProvider() {
    }

    public static TimetableService getService() {

        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://macbook:6080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(TimetableService.class);
        }

        return service;
    }

}
