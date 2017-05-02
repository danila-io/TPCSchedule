package ru.danilaionov.tpcschedule.models;

/**
 * Created by danilaionov on 03/04/2017.
 */

public class Group {

    private int id;
    private String name;

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }

}
