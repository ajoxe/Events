package com.example.android.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.DatabaseInitializer;

public class EventDetailActivity extends AppCompatActivity {

    Events event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        event =  DatabaseInitializer.event;
        //TODO when launching intent, call get event by id method in database initializer and pass in event id
        //TODO event should already be set after calling method.



    }
}
