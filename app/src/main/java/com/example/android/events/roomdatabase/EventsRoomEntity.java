package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;


import com.example.android.events.model.Classification;
import com.example.android.events.model.Dates;
import com.example.android.events.model.Start;
import com.example.android.events.model.Status;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by amirahoxendine on 2/6/18.
 */
@Entity(tableName = "events")
public class EventsRoomEntity {
    //@Embedded(prefix = "foo_")- prefix for embedded objects with the same name.
    //can embed dates.
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String id;
    private String seatmapImage;
    private String pleaseNote;
    private String info;
    private String genre_name;
    private String genre_id;
    private String segment__name;
    private String segment_id;

    private boolean date_spanMultipleDays;
    private String date_timezone;
    private boolean date_no_specific_time;
    private boolean date_time_tba;
    private boolean date_date_tba;
    private boolean date_date_tbd;
    private String date_date_time;
    private String date_local_time;
    private String date_local_date;

    private String locale;
    private String url;
    private String type;
    private String name;
    private String TABLE_NAME = "events";
    private double price_max;
    private double price_min;
    private String price_currency;
    private String price_type;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getSeatmapImage() {
        return seatmapImage;
    }

    public void setSeatmapImage(String seatmapImage) {
        this.seatmapImage = seatmapImage;
    }

    public String getPleaseNote() {
        return pleaseNote;
    }

    public void setPleaseNote(String pleaseNote) {
        this.pleaseNote = pleaseNote;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    public String getSegment__name() {
        return segment__name;
    }

    public void setSegment__name(String segment__name) {
        this.segment__name = segment__name;
    }

    public String getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(String segment_id) {
        this.segment_id = segment_id;
    }

    public boolean isDate_spanMultipleDays() {
        return date_spanMultipleDays;
    }

    public void setDate_spanMultipleDays(boolean date_spanMultipleDays) {
        this.date_spanMultipleDays = date_spanMultipleDays;
    }



    public String getDate_timezone() {
        return date_timezone;
    }

    public void setDate_timezone(String date_timezone) {
        this.date_timezone = date_timezone;
    }



    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public double getPrice_max() {
        return price_max;
    }

    public void setPrice_max(double price_max) {
        this.price_max = price_max;
    }

    public double getPrice_min() {
        return price_min;
    }

    public void setPrice_min(double price_min) {
        this.price_min = price_min;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public String getPrice_type() {
        return price_type;
    }

    public void setPrice_type(String price_type) {
        this.price_type = price_type;
    }

    public boolean isDate_no_specific_time() {
        return date_no_specific_time;
    }

    public void setDate_no_specific_time(boolean date_no_specific_time) {
        this.date_no_specific_time = date_no_specific_time;
    }

    public boolean isDate_time_tba() {
        return date_time_tba;
    }

    public void setDate_time_tba(boolean date_time_tba) {
        this.date_time_tba = date_time_tba;
    }

    public boolean isDate_date_tba() {
        return date_date_tba;
    }

    public void setDate_date_tba(boolean date_date_tba) {
        this.date_date_tba = date_date_tba;
    }

    public boolean isDate_date_tbd() {
        return date_date_tbd;
    }

    public void setDate_date_tbd(boolean date_date_tbd) {
        this.date_date_tbd = date_date_tbd;
    }

    public String getDate_date_time() {
        return date_date_time;
    }

    public void setDate_date_time(String date_date_time) {
        this.date_date_time = date_date_time;
    }

    public String getDate_local_time() {
        return date_local_time;
    }

    public void setDate_local_time(String date_local_time) {
        this.date_local_time = date_local_time;
    }

    public String getDate_local_date() {
        return date_local_date;
    }

    public void setDate_local_date(String date_local_date) {
        this.date_local_date = date_local_date;
    }




}
