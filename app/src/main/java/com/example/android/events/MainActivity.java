package com.example.android.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.events.roomdatabase.DatabaseInitializer;
import com.example.android.events.roomdatabase.EventsDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseInitializer.populateAsync(EventsDatabase.getEventsDatabase(this));
        DatabaseInitializer.queryDb(EventsDatabase.getEventsDatabase(this));


    }

    public void nextClass(View view) {
        Intent i = new Intent(MainActivity.this, DbTestEventsListActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        EventsDatabase.destroyInstance();
        super.onDestroy();
    }

    }

