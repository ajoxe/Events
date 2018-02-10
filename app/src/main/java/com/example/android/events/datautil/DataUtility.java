package com.example.android.events.datautil;

import com.example.android.events.model.PriceRanges;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by melg on 2/7/18.
 */

public class DataUtility {


    public String parseTime(String time,String timeZone) {
        TimeZone utc = TimeZone.getTimeZone(timeZone);
        DateFormat inputFormat = new SimpleDateFormat("HH:mm",
                Locale.US);
        inputFormat.setTimeZone(utc);
        DateFormat outputFormat = new SimpleDateFormat("hh:mm aa",
                Locale.US);
        outputFormat.setTimeZone(utc);

        Date date = new Date();
        try {
            date = inputFormat.parse(time);
            String output = outputFormat.format(date);
            return output;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String output = outputFormat.format(date);
        return output;
    }



    public String parseDate(String date){


        DateFormat inputFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.US);


        DateFormat outPutFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.US);


        Date dateFormatted = new Date();
        try {
            dateFormatted = inputFormat.parse(date);
            String output = outPutFormat.format(dateFormatted);
            return output;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String output = outPutFormat.format(dateFormatted);
        return output;



    }



}

