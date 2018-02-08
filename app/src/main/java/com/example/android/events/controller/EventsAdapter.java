package com.example.android.events.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.events.R;
import com.example.android.events.model.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melg on 2/6/18.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsListViewHolder> {
    List<Events> events = new ArrayList<>();
    Context context;
    View view;


    public EventsAdapter(List<Events> myEvents, Context context){
        this.events = myEvents;
        this.context = context;

    }

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_listview, parent, false);
        return new EventsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {

        holder.onBind(events.get(position));


    }

    @Override
    public int getItemCount() {
        return events.size();
    }
     class EventsListViewHolder extends RecyclerView.ViewHolder{

         public EventsListViewHolder(View itemView) {
             super(itemView);
         }



         public void onBind(Events events){




         }
     }
}