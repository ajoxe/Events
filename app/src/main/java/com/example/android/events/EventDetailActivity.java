package com.example.android.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.DatabaseInitializer;

public class EventDetailActivity extends AppCompatActivity {

    Events event;
    private TextView event_name;
    private ImageView event_image;
    private TextView event_info;
    private TextView event_prices;
    private TextView event_location;
    private TextView event_venue_name;
    private TextView event_venue_link;
    private double min;
    private double max;
    private String currencyType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        event = DatabaseInitializer.event;


        setViews();
        dataBinding();


    }

    public void setViews() {
        event_name = findViewById(R.id.dt_event_name);
        event_image = findViewById(R.id.dt_event_image);
        event_info = findViewById(R.id.dt_event_info);
        event_prices = findViewById(R.id.dt_event_prices);
        event_location = findViewById(R.id.dt_event_location);
        event_venue_name = findViewById(R.id.dt_event_venue_name);
        event_venue_link = findViewById(R.id.dt_venue_link);
    }

    public void dataBinding() {

        event_name.setText(event.getName());
        event_info.setText(event.getInfo());
        event_location.setText(event.getLocale());


        for (int i = 0; i < event.getPriceRanges().size(); i++) {
            max = event.getPriceRanges().get(i).getMax();
            min = event.getPriceRanges().get(i).getMin();
            currencyType = event.getPriceRanges().get(i).getCurrency();

        }
        event_prices.setText(min + " - " + max + " " + currencyType);
        event_venue_name.setText(event.get_embedded().getVenues().get(0).getName());
        event_venue_link.setText(event.get_embedded().getVenues().get(0).getUrl());


    }


}

