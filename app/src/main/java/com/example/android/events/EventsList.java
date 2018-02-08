package com.example.android.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.controller.EventsAdapter;
import com.example.android.events.model.Embedded;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by melg on 2/6/18.
 */

public class EventsList extends AppCompatActivity {
    List<Events> events = new ArrayList();
    String name;
    String price;
    String locale;
    String id;
    String pleaseNote;
    RecyclerView recyclerView;
    EventsAdapter eventsAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);

        recyclerView = findViewById(R.id.rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        eventsAdapter= new EventsAdapter(events, getApplicationContext());


        Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {
            public String TAG = "taggggg : ";

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {
                Log.d(TAG, "onResponse: " + " TRESPONSEE");

                if (response.isSuccessful()) {

                    events.addAll(response.body().get_embedded().getEvents());
                    recyclerView.setAdapter(eventsAdapter);

                }

            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

                t.printStackTrace();
            }
        });


    }


}
