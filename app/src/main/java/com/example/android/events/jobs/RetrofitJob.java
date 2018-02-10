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
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        EventsNotificationJob eventsNotificationJob = new EventsNotificationJob("Job Complete!", "Visit the app to check the current use of data",this);
        return false;
    }
}
