package com.example.android.events.roomdatabase;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * Created by amirahoxendine on 2/9/18.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final EventsDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final EventsDatabase db) {
        //populateWithTestData(db);
    }

    /*private static EventsRoomEntity addEvent(final EventsDatabase db, EventsRoomEntity event) {
        db.eventsDao().insertAll(event);
        return event;
    }

    private static void populateWithTestData(EventsDatabase db) {
        User user = new User();
        user.setFirstName("Ajay");
        user.setLastName("Saini");
        user.setAge(25);
        addUser(db, user);

        List<User> userList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
    }*/

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final EventsDatabase mDb;

        PopulateDbAsync(EventsDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //populateWithTestData(mDb);
            return null;
        }

    }
}
