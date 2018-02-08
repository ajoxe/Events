package com.example.android.events.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.events.model.Events;

/**
 * Created by melg on 2/6/18.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsListViewHolder> {

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
     class EventsListViewHolder extends RecyclerView.ViewHolder{

         public EventsListViewHolder(View itemView) {
             super(itemView);
         }

         public void onBind(Events events){


         }
     }
}