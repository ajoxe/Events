package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.android.events.model.Events;

import java.util.List;

/**
 * Created by amirahoxendine on 2/7/18.
 */

public class EventsWithImagesEntity {
    @Embedded
    EventsRoomEntity event;
    @Relation(parentColumn = "id", entityColumn = "eventID", entity = ImageRoomEntity.class)
    private List<ImageRoomEntity> images;

    public EventsRoomEntity getEvent() {
        return event;
    }

    public void setEvent(EventsRoomEntity event) {
        this.event = event;
    }

    public List<ImageRoomEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageRoomEntity> images) {
        this.images = images;
    }
}
