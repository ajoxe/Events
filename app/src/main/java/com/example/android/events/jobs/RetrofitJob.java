package com.example.android.events.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;

import com.example.android.events.roomdatabase.EventsDataManager;
import com.example.android.events.roomdatabase.EventsDatabase;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class RetrofitJob extends JobService {


    @Override
    public boolean onStartJob(final JobParameters params) {
        //ToDo: Add database code

        EventsDataManager.getEventsFromNetwork(EventsDatabase.getEventsDatabase(this), new JobFinishedListener() {
            @Override
            public void callJobFinished() {
                jobFinished(params, true);
                new EventsNotificationJob("Incoming!", "New events coming your way.", getApplicationContext());
            }
        });

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        EventsNotificationJob eventsNotificationJob = new EventsNotificationJob("Incoming!", "New events coming your way.", this);
        return false;
    }

    public interface JobFinishedListener {
        void callJobFinished();
    }

}