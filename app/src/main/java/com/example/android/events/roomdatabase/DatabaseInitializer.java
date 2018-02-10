package com.example.android.events.roomdatabase;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.events.model.Events;

import java.util.List;

/**
 * Created by amirahoxendine on 2/9/18.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();
    public EventsRoomDataUtility eventUtility = new EventsRoomDataUtility();

    public static void populateAsync(@NonNull final EventsDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final EventsDatabase db) {
        populateWithEventsData(db);
    }

    private static EventsRoomEntity addEvent(final EventsDatabase db, EventsRoomEntity event) {

        db.eventsDao().insertEvent(event);
        return event;
    }

    private static void populateWithEventsData(EventsDatabase db) {


        List<EventsRoomEntity> eventsList = db.eventsDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + eventsList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final EventsDatabase mDb;

        PopulateDbAsync(EventsDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithEventsData(mDb);
            return null;
        }

    }
}
