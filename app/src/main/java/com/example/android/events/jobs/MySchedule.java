package com.example.android.events.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class MySchedule extends JobService{


    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });


    public void init(){
        Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {
                Log.d("TAG", "onResponse: " + " TRESPONSEE");

                if (response.isSuccessful()) {

                    ArrayList<Events>events = new ArrayList<>();
                    events.addAll(response.body().get_embedded().getEvents());

                    for (int i = 0; i < events.size(); i++) {
                        //put event names into database
                        //events.get(i).getName();
                        //events.get(i).getId();
                        //events.get(i).getLocale();
                        //events.get(i).getInfo();

                    }


//                    Log.d(TAG, "onResponse: " + " name : " + name +  ", " + "locale :  " + locale + ", " +" ID" + id + "," + pleaseNote + " "+"THE END");

                }

            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

                t.printStackTrace();
            }
        });


    }

    @Override
    public boolean onStartJob(JobParameters params) {
        init();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        EventsNotificationJob eventsNotificationJob = new EventsNotificationJob("Job Complete!", "Visit the app to check the current use of data",this);
        return false;
    }
}
