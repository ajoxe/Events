package com.example.android.events.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class JobScheduler extends JobService{

    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
