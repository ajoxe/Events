package com.example.android.events;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.android.events.controller.EventsAdapter;
import com.example.android.events.model.Events;
import com.example.android.events.roomdatabase.EventsDataManager;
import com.example.android.events.roomdatabase.EventsDatabase;
import com.example.android.events.roomdatabase.EventsRoomDataUtility;

import java.util.List;

public class SavedEventsListActivity extends AppCompatActivity {
    List<Events> events = EventsDataManager.savedEventsList;
    EventsRoomDataUtility eventUtility = new EventsRoomDataUtility();
    public String TAG = EventsActivity.class.getSimpleName();
    RecyclerView recyclerView;
    EventsAdapter eventsAdapter;
    View.OnClickListener infoClick;
    View.OnClickListener saveCheckboxClick;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);
        events = EventsDataManager.getSavedEventsList(EventsDatabase.getEventsDatabase(getApplicationContext()));
        context = getApplicationContext();
        setRecyclerView();
    }

    public void setRecyclerView(){
        recyclerView = findViewById(R.id.rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        setInfoClick();
        setSaveCheckboxClick();
        Log.d(TAG, "list size" + events.size());
        eventsAdapter= new EventsAdapter(events, getApplicationContext(), infoClick, saveCheckboxClick);
        recyclerView.setAdapter(eventsAdapter);
        //recyclerView.setItemViewCacheSize();
    }

    public void setInfoClick(){
        infoClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = v.getTag().toString();
                EventsDataManager.getEventById(EventsDatabase.getEventsDatabase(context),id);
                Intent detailIntent = new Intent(SavedEventsListActivity.this, EventDetailActivity.class);
                startActivity(detailIntent);
            }
        };
    }

    public void setSaveCheckboxClick(){
        saveCheckboxClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = v.getTag().toString();
                CheckBox checkbox = (CheckBox) v.findViewWithTag(id);

                if(checkbox.isChecked()) {
                    EventsDataManager.saveEvent(EventsDatabase.getEventsDatabase(context), id);
                    eventUtility.getEventfromMap(eventUtility.eventsHashMap(events), id).setSaved(true);
                    eventsAdapter.notifyDataSetChanged();
                    Log.d(TAG, "event saved");
                } else if(!checkbox.isChecked()){

                    eventUtility.getEventfromMap(eventUtility.eventsHashMap(events), id).setSaved(false);
                    Events event = eventUtility.getEventfromMap(eventUtility.eventsHashMap(events), id);

                    events.remove(event);
                    EventsDataManager.deleteEvent(EventsDatabase.getEventsDatabase(context), id);
                    eventsAdapter.notifyDataSetChanged();
                    Log.d(TAG, "event deleted");
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        EventsDatabase.destroyInstance();
        super.onDestroy();
    }



}
