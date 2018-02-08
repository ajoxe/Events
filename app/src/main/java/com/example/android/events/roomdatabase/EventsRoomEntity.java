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
    @PrimaryKey
    private String id;
    @Embedded
    private Dates dates;
    private String seatmapImage;
    private String pleaseNote;
    private String info;
    private String genre_name;
    private String genre_id;
    private String segment__name;
    private String segment_id;
    private boolean date_spanMultipleDays;
    private Status date_status;
    private String date_timezone;
    private Start date_start;
    private String locale;
    private String url;
    private String type;
    private String name;
    private String TABLE_NAME = "events";
    private double price_max;
    private double price_min;
    private String price_currency;
    private String price_type;




    public void parseClassifications(List<Classification> classifications){
        this.genre_id = classifications.get(0).getGenre().getId();
        this.genre_name = classifications.get(0).getGenre().getName();
        this.segment_id = classifications.get(0).getSegment().getId();
        this.segment__name = classifications.get(0).getSegment().getName();
    }


}
