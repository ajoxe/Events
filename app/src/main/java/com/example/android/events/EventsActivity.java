package com.example.android.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.controller.EventsAdapter;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.DatabaseInitializer;
import com.example.android.events.roomdatabase.EventsDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by melg on 2/6/18.
 */

public class EventsActivity extends AppCompatActivity {
    List<Events> events = DatabaseInitializer.eventsQuery;
    public String TAG = EventsActivity.class.getSimpleName();
    RecyclerView recyclerView;
    EventsAdapter eventsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);

        init();
    }

    public void init(){
        recyclerView = findViewById(R.id.rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Log.d("DB TEST", "list size" + events.size());
        eventsAdapter= new EventsAdapter(events, getApplicationContext());
        recyclerView.setAdapter(eventsAdapter);
    }

    @Override
    protected void onDestroy() {
        EventsDatabase.destroyInstance();
        super.onDestroy();
    }

}


