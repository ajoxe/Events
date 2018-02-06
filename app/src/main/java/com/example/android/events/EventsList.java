package com.example.android.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.events.RetrofitInstance.RetroFitInstance;
import com.example.android.events.model.Embedded;
import com.example.android.events.model.EventWrapper;
import com.example.android.events.model.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by melg on 2/6/18.
 */

public class EventsList extends AppCompatActivity{
    List<Events> events;
   String name;
   String price;
   String locale;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);

        Call<EventWrapper> getEventsDetails = RetroFitInstance.getInstance()
                .getApi()
                .getEventResponse("US");
        getEventsDetails.enqueue(new Callback<EventWrapper>() {
            public String TAG;

            @Override
            public void onResponse(Call<EventWrapper> call, Response<EventWrapper> response) {

                if(response.isSuccessful()){

                    events.addAll(response.body().get_embedded().getEvents());

                    for (int i = 0; i <events.size() ; i++) {
                       name =  events.get(i).getName();
                       price = events.get(i).getId();
                       locale = events.get(i).getLocale();

                    }


                    Log.d(TAG, "onResponse: " + name  + " <- name " + " " + price + "<- price "+ " " + locale + " " + "<- locale name " );

                }

            }

            @Override
            public void onFailure(Call<EventWrapper> call, Throwable t) {

            }
        });


    }


}
