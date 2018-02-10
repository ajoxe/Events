package com.example.android.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.android.events.jobs.JobScheduler;
import com.example.android.events.roomdatabase.EventsDataManager;
import com.example.android.events.roomdatabase.EventsDatabase;

public class MainActivity extends AppCompatActivity {
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JobScheduler.start(getApplicationContext());
        logoImage = findViewById(R.id.logo_image);

        EventsDataManager.populateEventsDatabaseAsync(EventsDatabase.getEventsDatabase(this));
        EventsDataManager.queryDb(EventsDatabase.getEventsDatabase(this));


    }

    public void nextClass(View view) {
        Intent i = new Intent(MainActivity.this, EventsActivity.class);
        startActivity(i);
    }

    public void savedClass(View view) {
        Intent s = new Intent(MainActivity.this, SavedEventsListActivity.class);
        startActivity(s);
    }

    @Override
    protected void onDestroy() {
        EventsDatabase.destroyInstance();
        super.onDestroy();
    }

}

