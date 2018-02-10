package com.example.android.events.roomdatabase;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.jobs.RetrofitJob;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amirahoxendine on 2/9/18.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();
    public static EventsRoomDataUtility eventUtility = new EventsRoomDataUtility();
    public static List<Events> savedEventsList = new ArrayList<>();
    public static List<Events> eventsQuery;
    public static Events event;



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

    private static Events getEventByIdAsync(@NonNull final EventsDatabase db, String id){
        return eventUtility.entityToEvents(db.eventsDao().findEventByID(id));
    }

    public static Events getEventById(@NonNull final EventsDatabase db, String id){
        QuerySingleEventAsync getEventTask = new QuerySingleEventAsync(db,id);
        getEventTask.execute();
        return event;
    }

    public static void saveEvent(final EventsDatabase db, String id ){
        InsertSavedEventAsync savedAsync = new InsertSavedEventAsync(db, id);
        savedAsync.execute();
    }

    public static void deleteEvent(final EventsDatabase db, String id){
        DeleteSavedEventAsync deleteEventTask = new DeleteSavedEventAsync(db,id);
        deleteEventTask.execute();
    }


    public static List<Events> getSavedEventsList(final EventsDatabase db){
        savedEventsList = eventUtility.entitiesToEvents(db.eventsDao().getSaved());
        return savedEventsList;
    }


    public static void getEventsFromNetwork(@NonNull final EventsDatabase db) {
        doStuff(db, null);
    }

    public static void getEventsFromNetwork(@NonNull final EventsDatabase db, final RetrofitJob.JobFinishedListener listener){
        Log.d(TAG, "retrofit job: " + " database entry count" + databasEntryCount(db));
       doStuff(db, listener);
    }

    private static void doStuff(@NonNull final EventsDatabase db, final RetrofitJob.JobFinishedListener listener){
        final List<Events> events = new ArrayList();
        Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {
                Log.d(TAG, "onResponse: " + " TRESPONSEE");

                if (response.isSuccessful()) {
                    events.addAll(response.body().getEmbedded().getEvents());
                    List<EventsRoomEntity> entities = eventUtility.eventsToEntity(events);
                    if(databasEntryCount(db) != 0) {
                        db.eventsDao().deleteAllEvents(db.eventsDao().getNotSaved());
                    }
                    db.eventsDao().insertAllEvents(entities);
                    eventsQuery = eventUtility.entitiesToEvents(db.eventsDao().getNotSaved());

                    Log.d(TAG, "onResponse: " + " TRESPONSEE response size" + events.size());
                    Log.d(TAG, "onResponse: " + " TRESPONSEE eventsQuery" + eventsQuery.size());

                    Log.d(TAG, "onResponse: " + " TRESPONSEE eventsQuery" + eventsQuery.size());
                    if (listener!= null){
                        listener.callJobFinished();
                    }
                }
            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

                if (listener!= null) {
                    listener.callJobFinished();
                }
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
    }

    /*get saved events from the db asynchronously*/
    private static class QuerySavedDbAsync extends AsyncTask<Void, Void, List<Events>> {

        private final EventsDatabase mDb;

        QuerySavedDbAsync(EventsDatabase db) {
            mDb = db;
        }
        protected List<Events> doInBackground(Void... voids) {

            return getSavedEventsList(mDb);
        }
    }

    /*get single event from the db asynchronously*/
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
    }
    /*save single event from to db asynchronously*/
    private static class InsertSavedEventAsync extends AsyncTask<Void, Void, Void> {

        private final EventsDatabase mDb;
        private String id;
        private Events saveEvent;

        InsertSavedEventAsync(EventsDatabase db, String id) {
            this.id = id;
            mDb = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            saveEvent = eventUtility.getEventfromMap(eventUtility.eventsHashMap(eventsQuery), id);
            saveEvent.setSaved(true);
            savedEventsList.add(saveEvent);
            EventsRoomEntity eventEntity = eventUtility.eventToEntity(saveEvent, "saved");
            mDb.eventsDao().insertEvent(eventEntity);
            return null;
        }
    }

        /*delete single event from to db asynchronously*/
        private static class DeleteSavedEventAsync extends AsyncTask<Void, Void, Void> {

            private final EventsDatabase mDb;
            private String id;
            private Events event;

            DeleteSavedEventAsync(EventsDatabase db, String id) {
                this.id = id;
                mDb = db;
            }

            @Override
            protected Void doInBackground(Void... voids) {
                event = eventUtility.getEventfromMap(eventUtility.eventsHashMap(eventsQuery), id);
                savedEventsList.remove(event);
                mDb.eventsDao().deleteEvent(mDb.eventsDao().findEventByID(id));
                return null;
            }
    }



}
