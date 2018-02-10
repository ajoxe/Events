package com.example.android.events.roomdatabase;

import com.example.android.events.model.Classification;
import com.example.android.events.model.Events;
import com.example.android.events.model.Images;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amirahoxendine on 2/6/18.
 */

public class EventsRoomDataUtility {
    //Events event;
   //EventsRoomEntity eventEntity;

   public EventsRoomEntity eventToEntity(Events event, String status){
       EventsRoomEntity eventEntity = new EventsRoomEntity();
       eventEntity.setName(event.getName());
       eventEntity.setType(event.getType());
       eventEntity.setUrl(event.getUrl());
       eventEntity.setLocale(event.getLocale());
       eventEntity.setInfo(event.getInfo());
       eventEntity.setPleaseNote(event.getPleaseNote());
       eventEntity.setSeatmap(event.getSeatmap());
       eventEntity.setDates(event.getDates());
       eventEntity.setPriceRanges(event.getPriceRanges());
       eventEntity.setProducts(event.getProducts());
       eventEntity.setImages(event.getImages());
       eventEntity.setClassifications(event.getClassifications());
       eventEntity.set_embedded(event.get_embedded());
       eventEntity.setStatus(status);
       return eventEntity;
   }

    public Events entityToEvents(EventsRoomEntity eventsRoomEntity){
        Events event = new Events();
        event.setName(eventsRoomEntity.getName());
        event.setType(eventsRoomEntity.getType());
        event.setUrl(eventsRoomEntity.getUrl());
        event.setLocale(eventsRoomEntity.getLocale());
        event.setInfo(eventsRoomEntity.getInfo());
        event.setPleaseNote(eventsRoomEntity.getPleaseNote());
        event.setSeatmap(eventsRoomEntity.getSeatmap());
        event.setDates(eventsRoomEntity.getDates());
        event.setPriceRanges(eventsRoomEntity.getPriceRanges());
        event.setProducts(eventsRoomEntity.getProducts());
        event.setImages(eventsRoomEntity.getImages());
        event.setClassifications(eventsRoomEntity.getClassifications());
        event.set_embedded(eventsRoomEntity.get_embedded());
        return event;
    }


   //List<ImageRoomEntity> imageRoomEntityList;

   /* //Pojo -> Entity conversions
    public com.example.android.events.roomdatabase.EventsRoomEntity convertEventToEntity(Events event){
        com.example.android.events.roomdatabase.EventsRoomEntity eventEntity = new com.example.android.events.roomdatabase.EventsRoomEntity();
        eventEntity.setName(event.getName());
        eventEntity.setType(event.getType());
        eventEntity.setUrl(event.getUrl());
        eventEntity.setLocale(event.getLocale());
        eventEntity.setInfo(event.getInfo());
        eventEntity.setPleaseNote(event.getPleaseNote());
        //seatmap
        eventEntity.setSeatmapImage(event.getSeatmap().getStaticUrl());
        //dates
        eventEntity.setDate_spanMultipleDays(event.getDates().getSpanMultipleDays());
        eventEntity.setDate_timezone(event.getDates().getTimezone());
        eventEntity.setDate_date_tba(event.getDates().getStart().getDateTBA());
        eventEntity.setDate_date_tbd(event.getDates().getStart().getDateTBD());
        eventEntity.setDate_time_tba(event.getDates().getStart().getTimeTBA());
        eventEntity.setDate_date_time(event.getDates().getStart().getDateTime());
        eventEntity.setDate_local_date(event.getDates().getStart().getLocalDate());
        eventEntity.setDate_local_time(event.getDates().getStart().getLocalTime());
        //price ranges
        eventEntity.setPrice_currency(event.getPriceRanges().get(0).getCurrency());
        eventEntity.setPrice_max(event.getPriceRanges().get(0).getMax());
        eventEntity.setPrice_min(event.getPriceRanges().get(0).getMin());
        eventEntity.setPrice_type(event.getPriceRanges().get(0).getType());
        //classifications
        parseClassifications(event.getClassifications());
    return eventEntity;
    }

    public void parseClassifications(List<Classification> classifications){
        eventEntity.setGenre_id(classifications.get(0).getGenre().getId());
        eventEntity.setGenre_name(classifications.get(0).getGenre().getName());
        eventEntity.setSegment_id(classifications.get(0).getSegment().getId());
        eventEntity.setSegment__name(classifications.get(0).getSegment().getName());
    }

    public ImageRoomEntity convertImagetoEntity(Images image, String id){
        ImageRoomEntity imageEntity = new ImageRoomEntity();
        imageEntity.setEventID(id);
        imageEntity.setFallback(image.getFallback());
        imageEntity.setHeight(image.getHeight());
        imageEntity.setWidth(image.getWidth());
        imageEntity.setUrl(image.getUrl());
        imageEntity.setRatio(image.getRatio());
        return imageEntity;
    }

    public List<ImageRoomEntity> buildImageEntityList(List<Images> eventImageList, String id){
        imageRoomEntityList = new ArrayList<>();
        for (Images image : eventImageList){
            imageRoomEntityList.add(convertImagetoEntity(image, id));
        }
        return imageRoomEntityList;
    }
    //Entity -> Pojo conversions
    public Events convertEntityToEventsPojo(com.example.android.events.roomdatabase.EventsRoomEntity eventEntity, ImageRoomEntity imageRoomEntity){
        event = new Events();


        return event;
    }*/

}
