package com.example.android.events;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

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
    View.OnClickListener infoClick;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);
        context = getApplicationContext();

        setRecyclerView();
    }

    public void setRecyclerView(){
        recyclerView = findViewById(R.id.rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        setInfoClick();
        Log.d("DB TEST", "list size" + events.size());
        eventsAdapter= new EventsAdapter(events, getApplicationContext(), infoClick);
        recyclerView.setAdapter(eventsAdapter);
    }

    public void setInfoClick(){
        infoClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = v.getTag().toString();
                DatabaseInitializer.getEventById(EventsDatabase.getEventsDatabase(context),id);
                Intent detailIntent = new Intent(EventsActivity.this, EventDetailActivity.class);
                startActivity(detailIntent);
            }
        };
    }

    @Override
    protected void onDestroy() {
        EventsDatabase.destroyInstance();
        super.onDestroy();
    }



}


