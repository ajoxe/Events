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

    private static final int NOTIFICATION_ID = 555;
    private Context context;
    private PendingIntent pendingIntent;
    private NotificationManager notificationManager;

    public EventsNotificationJob(String title, String description, Context context) {
        this.context = context;
        initClass();
        initNot(title, description);
    }

    public void initClass() {
        Intent intent = new Intent(context, MainActivity.class);
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
        pendingIntent = PendingIntent.getActivity(context, requestID, intent, flags);
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void initNot(String title, String description) {
        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_icon)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

}
