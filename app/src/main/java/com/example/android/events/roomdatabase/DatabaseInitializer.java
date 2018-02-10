package com.example.android.events.roomdatabase;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amirahoxendine on 2/9/18.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();
    public static EventsRoomDataUtility eventUtility = new EventsRoomDataUtility();
    private static List<Events> eventsList = new ArrayList<>();
    public static List<Events> eventsQuery;
    public static Events event;

    public static List<Events> getEventsList() {
        return eventsList;
    }

    public static void setEventsList(List<Events> eventsList) {
        DatabaseInitializer.eventsList = eventsList;
    }


    public static void populateAsync(@NonNull final EventsDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void updateEventsJobAsync(@NonNull final EventsDatabase db) {
        UpdateDbAsync updateTask = new UpdateDbAsync(db);
        updateTask.execute();
    }

    public static List<Events> queryDb(@NonNull final EventsDatabase db){
        QueryDbAsync listTask = new QueryDbAsync(db);
        listTask.execute();
        return eventsQuery;
    }

    private static List<Events> getEventsFromDB(@NonNull final EventsDatabase db){
        eventsQuery = eventUtility.entitiesToEvents(db.eventsDao().getAll());
        Log.d("get events", "eventsQuery size" + eventsQuery.size());
        return eventsQuery;
    }
    //checks to see if db is empty
    private static int databasEntryCount(@NonNull final EventsDatabase db){
        return db.eventsDao().countEvents();
    }

    public static Events getEventByIdAsync(@NonNull final EventsDatabase db, String id){
        return eventUtility.entityToEvents(db.eventsDao().findEventByID(id));
    }

    public static Events getEventById(@NonNull final EventsDatabase db, String id){
        QuerySingleEventAsync getEventTask = new QuerySingleEventAsync(db,id);
        getEventTask.execute();
        return event;
    }

    /*private static void addEvent(final EventsDatabase db, EventsRoomEntity event) {
        db.eventsDao().insertEvent(event);
    }

    public static List<Events> queryEvents(List<Events> events){
        return events;
    }*/




    private static void getEventsFromNetwork(@NonNull final EventsDatabase db){
         final List<Events> events = new ArrayList();
        Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {
                Log.d(TAG, "onResponse: " + " TRESPONSEE");

                if (response.isSuccessful()) {
                    events.addAll(response.body().get_embedded().getEvents());
                    List<EventsRoomEntity> entities = eventUtility.eventsToEntity(events);
                    db.eventsDao().insertAllEvents(entities);
                    eventsQuery = eventUtility.entitiesToEvents(db.eventsDao().getAll());

                    Log.d(TAG, "onResponse: " + " TRESPONSEE response size" + events.size());
                    Log.d(TAG, "onResponse: " + " TRESPONSEE eventsList" + eventsQuery.size());
                }

            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }

    /*populate the db with retrofit call if db is empty*/

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final EventsDatabase mDb;

        PopulateDbAsync(EventsDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            if (databasEntryCount(mDb) == 0){
                getEventsFromNetwork(mDb);
            }
            return null;
        }
    }
    /*update the db with new retrofit call*/
    private static class UpdateDbAsync extends AsyncTask<Void, Void, Void> {

        private final EventsDatabase mDb;

        UpdateDbAsync(EventsDatabase db) {
            mDb = db;
        }
        @Override
        protected Void doInBackground(final Void... params) {
                getEventsFromNetwork(mDb);
            return null;
        }

    }

    /*get events from the db asynchronously*/
    private static class QueryDbAsync extends AsyncTask<Void, Void, List<Events>> {

        private final EventsDatabase mDb;

        QueryDbAsync(EventsDatabase db) {
            mDb = db;
        }


        protected List<Events> doInBackground(Void... voids) {
            return getEventsFromDB(mDb);
        }


        /*@Override
        protected void onPostExecute(List<Events> result){
            eventsQuery = new ArrayList<>();
            eventsQuery.addAll(result);
            Log.d(TAG, "query async: " + "response" + eventsQuery.size());
        }*/
    }

    private static class QuerySingleEventAsync extends AsyncTask<Void, Void, Events> {

        private final EventsDatabase mDb;
        private String id;
        QuerySingleEventAsync(EventsDatabase db, String id) {
            this.id = id;
            mDb = db;
        }



        @Override
        protected Events doInBackground(Void... voids) {
            event = getEventByIdAsync(mDb, id);
            return event;
        }


        /*@Override
        protected void onPostExecute(List<Events> result){
            eventsQuery = new ArrayList<>();
            eventsQuery.addAll(result);
            Log.d(TAG, "query async: " + "response" + eventsQuery.size());
        }*/
    }

}
