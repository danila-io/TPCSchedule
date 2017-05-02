package ru.danilaionov.tpcschedule.models;

/**
 * Created by danilaionov on 27/04/2017.
 */

public class DBLesson {

    private int number;
    private String name;
    private int dayNumber;

    public DBLesson(int number, String name, int dayNumber) {
        this.number = number;
        this.name = name;
        this.dayNumber = dayNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

}
