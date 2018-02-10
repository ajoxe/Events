package com.example.android.events.jobs;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import static android.app.job.JobScheduler.RESULT_FAILURE;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class MyJobSch {

    private final static String TAG = MyJobSch.class.getSimpleName();

    public final static int RETROFIT_JOB_ID = 0;


    public static void start(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        buildRetrofitJob(context, jobScheduler);
    }

    private static void buildRetrofitJob(Context applicationContext, JobScheduler jobScheduler) {
        JobInfo.Builder retrofitBuilder = new JobInfo
                .Builder(RETROFIT_JOB_ID, new ComponentName(applicationContext, RetrofitJob.class))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_METERED)
                .setOverrideDeadline(3000)
                .setRequiresDeviceIdle(false)
                .setRequiresCharging(false);


        if (jobScheduler.schedule(retrofitBuilder.build()) <= RESULT_FAILURE) {
            Log.d(TAG, "start: ~~~ Retrofit Job Execution: Failure! ~~~~");

        } else {
            Log.d(TAG, "start: ~~~ Retrofit Job Execution: Success!~~~~");
        }
    }

}
