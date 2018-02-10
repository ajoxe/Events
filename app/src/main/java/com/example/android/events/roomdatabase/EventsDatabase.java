package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by amirahoxendine on 2/7/18.
 */
@Database(entities = {EventsRoomEntity.class}, version = 1)
@TypeConverters(DataConverter.class)
public abstract class EventsDatabase extends RoomDatabase {

    private static EventsDatabase INSTANCE;
    public abstract EventsDao eventsDao();



    public static EventsDatabase getEventsDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), EventsDatabase.class, "events")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

