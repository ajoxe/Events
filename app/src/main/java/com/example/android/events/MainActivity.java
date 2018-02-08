package com.example.android.events;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.events.roomdatabase.EventsDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventsDatabase db = Room.databaseBuilder(getApplicationContext(),
                EventsDatabase.class, "events").build();
    }

    public void nextClass(View view) {
        Intent i = new Intent(MainActivity.this, EventsList.class);
        startActivity(i);
    }
}
