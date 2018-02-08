package com.example.android.events.datautil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by melg on 2/7/18.
 */

public class DataUtility {


    public String parseTime(String time) {
        TimeZone utc = TimeZone.getTimeZone("etc/UTC");
        DateFormat inputFormat = new SimpleDateFormat("dd MMM, yyyy HH:mm",
                Locale.US);
        inputFormat.setTimeZone(utc);
        DateFormat outputFormat = new SimpleDateFormat("dd MMM, yyyy hh:mm aa",
                Locale.US);
        outputFormat.setTimeZone(utc);

        Date date = null;
        try {
            date = inputFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
            String output = outputFormat.format(date);
        return output;
    }

}

