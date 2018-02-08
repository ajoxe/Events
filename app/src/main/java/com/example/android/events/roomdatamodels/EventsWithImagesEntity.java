package com.example.android.events.roomdatamodels;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.android.events.model.Events;

import java.util.List;

/**
 * Created by amirahoxendine on 2/7/18.
 */

public class EventsWithImagesEntity {
    @Embedded
    Events event;
    @Relation(parentColumn = "id", entityColumn = "eventId", entity = ImageRoomEntity.class)
    private List<ImageRoomEntity> images;
}
