package com.centerorbit.hive_daq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;


/**
 * Created by joe on 1/1/14.
 */
public class AMElib {


    //converts Int from date picker into String to be stored in SQLite in date format.
    public static String dateInt_to_String(int month, int day, int year)
    {
        Calendar date = Calendar.getInstance();
        date.set(year,month,day);

        // Create an instance of SimpleDateFormat used for formatting
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        // Using DateFormat format method we can create a string representation of a date with the defined format.
        String reportDate = df.format(date.getTime());

        return reportDate;
    }

}