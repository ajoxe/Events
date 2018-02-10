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


   public EventsRoomEntity eventToEntity(Events event, String status){
       EventsRoomEntity eventEntity = new EventsRoomEntity();
       eventEntity.setId(event.getId());
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
        event.setId(eventsRoomEntity.getId());
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

    public List<EventsRoomEntity> eventsToEntity(List<Events> events){
        List<EventsRoomEntity> entities = new ArrayList<>();
        for (Events event : events){
            EventsRoomEntity entity = eventToEntity(event, "not saved");
            entities.add(entity);
        }
        return entities;
    }

    public List<Events> entitiesToEvents(List<EventsRoomEntity> entities){
        List<Events> events = new ArrayList<>();
        for (EventsRoomEntity entity : entities){
            Events event = entityToEvents(entity);
            events.add(event);
        }
        return events;
    }

}
