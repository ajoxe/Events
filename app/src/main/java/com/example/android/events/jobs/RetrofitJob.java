package com.example.android.events.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.DatabaseInitializer;
import com.example.android.events.roomdatabase.EventsDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static java.util.Collections.addAll;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class RetrofitJob extends JobService{


    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });


    @Override
    public boolean onStartJob(final JobParameters params) {
        //ToDo: Add database code

        DatabaseInitializer.getEventsFromNetwork(EventsDatabase.getEventsDatabase(this), new JobFinishedListener(){
            @Override
            public void callJobFinished() {
                jobFinished(params, true);
            }
        });


        /*Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {
                Log.d(TAG, "onResponse: " + " TRESPONSEE");

                if (response.isSuccessful()) {

                    Log.d(TAG, "retrofitjobCall: "+ response.body().getEmbedded().getEvents().toString());
//                    events.addAll(response.body().getEmbedded().getEvents());
//                    recyclerView.setAdapter(eventsAdapter);


                    List<Events> events = new ArrayList<>();
                    events.addAll(response.body().getEmbedded().getEvents());


                }

            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

                t.printStackTrace();
            }
        });*/

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        EventsNotificationJob eventsNotificationJob = new EventsNotificationJob("Job Complete!", "Visit the app to check the current use of data",this);
        return false;
    }

    public interface JobFinishedListener {
        void callJobFinished();
    }

}