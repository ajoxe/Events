package com.example.android.events.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Relation;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amirahoxendine on 2/6/18.
 */

public class EventsRoomEntity implements Entity {
    //@Embedded(prefix = "foo_")- prefix for embedded objects with the same name.
    //can embed dates.
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
    @Relation(parentColumn = "id", entityColumn = "eventId", entity = ImageRoomEntity.class)
    private List<ImageRoomEntity> images;
    private String locale;
    private String url;
    private String id;
    private String type;
    private String name;
    private String TABLE_NAME = "events";


    public EventsRoomEntity(Events event){
        this.id = event.getId();
        this.name = event.getName();
        this.type = event.getType();
        this.url = event.getUrl();
        this.locale = event.getLocale();
        this.info = event.getInfo();
        this.pleaseNote = event.getPleaseNote();
        this.images = addIdsToImages(event.getImages());
        this.seatmapImage = event.getSeatmap().getStaticUrl();
        this.date_spanMultipleDays = event.getDates().getSpanMultipleDays();
        this.date_status = event.getDates().getStatus();
        this.date_timezone = event.getDates().getTimezone();
        this.date_start = event.getDates().getStart();
        parseClassifications(event.getClassifications());
    }

    public void parseClassifications(List<Classification> classifications){
        this.genre_id = classifications.get(0).getGenre().getId();
        this.genre_name = classifications.get(0).getGenre().getName();
        this.segment_id = classifications.get(0).getSegment().getId();
        this.segment__name = classifications.get(0).getSegment().getName();
    }
    /*Adds id's for relations'*/
    public List<ImageRoomEntity> addIdsToImages(List<Images> pojoImages){
        images = new ArrayList<>();
        for (Images image: pojoImages){
            ImageRoomEntity roomImage = new ImageRoomEntity(image);
            roomImage.setEventID(this.id);
            images.add(roomImage);
        }
        return images;
    }

    /*Overrides*/

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    @Override
    public Index[] indices() {
        return new Index[0];
    }

    @Override
    public boolean inheritSuperIndices() {
        return false;
    }

    @Override
    public String[] primaryKeys() {
        return new String[0];
    }

    @Override
    public ForeignKey[] foreignKeys() {
        return new ForeignKey[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
