package com.example.android.events;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.events.datautil.DataUtility;
import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.DatabaseInitializer;
import com.squareup.picasso.Picasso;

public class EventDetailActivity extends AppCompatActivity {

    Events event;
    private TextView event_name;
    private ImageView event_image;
    private TextView event_prices;
    private TextView event_time;
    private TextView event_venue_name;
    private Button buynow;
    private TextView event_date;
    DataUtility dataUtility = new DataUtility();
    private double min;
    private double max;
    private String currencyType;
    private String timeZone;
    private String timeParsed;
    private String dateformated;




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
        event_prices = findViewById(R.id.dt_event_prices);
        event_time = findViewById(R.id.dt_event_time);
        event_venue_name = findViewById(R.id.dt_event_venue_name);
        event_date = findViewById(R.id.event_date);
        buynow = findViewById(R.id.buy_now);
    }

    public void dataBinding() {

        event_name.setText(event.getName());
        event_venue_name.setText(event.get_embedded().getVenues().get(0).getName());



        for (int i = 0; i < event.getPriceRanges().size(); i++) {
            max = event.getPriceRanges().get(i).getMax();
            min = event.getPriceRanges().get(i).getMin();
            currencyType = event.getPriceRanges().get(i).getCurrency();

        }
        event_prices.setText("Price Range: "+(int)min + " - " + (int)max + " " + currencyType);

        timeZone = event.getDates().getTimezone();
        timeParsed = dataUtility.parseTime(event.getDates().getStart().getLocalTime(), timeZone);
        dateformated = dataUtility.parseDate(event.getDates().getStart().getLocalDate());

        event_time.setText("Time: " + timeParsed);
        event_date.setText("Date: " + dateformated);

        Picasso.with(getApplicationContext())
                .load(event.getImages().get(8)
                        .getUrl())
                .into(event_image);


    } public void onClick(View view){
        Uri uri = Uri.parse(event.getUrl()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void venueOnClick(View view){
        Uri uri = Uri.parse(event.get_embedded().getVenues().get(0).getUrl()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void seatingChartOnClick(View view){
        Uri uri = Uri.parse(event.getSeatmap().getStaticUrl()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


}

