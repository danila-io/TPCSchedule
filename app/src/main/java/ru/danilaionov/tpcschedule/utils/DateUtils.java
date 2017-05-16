package ru.danilaionov.tpcschedule.utils;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.danilaionov.tpcschedule.R;

/**
 * Created by danilaionov on 11/05/2017.
 */

public final class DateUtils
{
    private static Context context;

    private static final Locale LOCALE = new Locale("ru", "RU");

    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE", LOCALE);

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM", LOCALE);

    private static final String MISSING_CONTEXT_ERROR_MSG = "You must set application context before using other DateUtils methods";

    private DateUtils() {}

    public static void setContext(Context context)
    {
        DateUtils.context = context;
    }

    public static String toDateString(Date date)
    {
        return DATE_FORMAT.format(date);
    }

    public static Date toDate(String string) throws ParseException
    {
        return DATE_FORMAT.parse(string);
    }

    public static boolean isDate(String value)
    {
        try
        {
            DateUtils.toDate(value);
        }
        catch (ParseException e)
        {
            return false;
        }

        return true;
    }

    public static boolean equalsDayOfWeek(Date date, int dayOfWeek)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_WEEK) == dayOfWeek;
    }

    public static String getCurrentDayOfWeek()
    {
        Calendar calendar = Calendar.getInstance(LOCALE);
        return DAY_FORMAT.format(calendar.getTime());
    }

    public static String getDateShort()
    {
        Calendar calendar = Calendar.getInstance(LOCALE);
        return DATE_FORMAT.format(calendar.getTime());
    }

    public static String getDayOfWeek(int dayNumber)
    {
        String[] daysOfWeek = context.getResources().getStringArray(R.array.daysOfWeek);

        if (dayNumber > 7) {
            dayNumber = dayNumber - 7;
        }

        return daysOfWeek[dayNumber - 1];
    }

    public static boolean isToday(Date date)
    {
        if (date == null)
        {
            return false;
        }

        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return (now.get(Calendar.ERA) == calendar.get(Calendar.ERA) &&
                now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                now.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR));
    }
}

