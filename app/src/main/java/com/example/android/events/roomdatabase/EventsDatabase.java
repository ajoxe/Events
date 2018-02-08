package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by amirahoxendine on 2/7/18.
 */
@Database(entities = {EventsRoomEntity.class, ImageRoomEntity.class, VenueRoomEntity.class}, version = 1)
public abstract class EventsDatabase extends RoomDatabase {

}
