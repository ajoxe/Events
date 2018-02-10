package com.example.android.events.jobs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.example.android.events.MainActivity;
import com.example.android.events.R;

/**
 * Created by amirahoxendine on 2/5/18.
 */

public class EventsNotificationJob {

    private String title, description;
    private int NOTIFICATION_ID = 555;
    private Context context;
    private Intent intent ;
    private int requestID ;
    private int flags;
    private PendingIntent pendingIntent;
    private Notification notification;
    private NotificationManager notificationManager;

    public EventsNotificationJob(String title, String description, Context context){
        this.context = context;
        this.title = title;
        this.description = description;
        initClass();
        initNot(title,description);
    }



    public void initClass() {
        intent = new Intent(context, MainActivity.class);
        requestID = (int) System.currentTimeMillis();
        flags = PendingIntent.FLAG_CANCEL_CURRENT;
        pendingIntent = PendingIntent.getActivity(context, requestID, intent, flags);
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    }



    public void initNot(String title, String description) {
        notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_icon)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(NOTIFICATION_ID, notification);

    }

}
