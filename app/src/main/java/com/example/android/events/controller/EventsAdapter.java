package com.example.android.events.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.events.R;
import com.example.android.events.datautil.DataUtility;
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
   public   DataUtility dataUtility = new DataUtility();


    public EventsAdapter(List<Events> myEvents, Context context){
        this.events = myEvents;
        this.context = context;

    }

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_itemview, parent, false);
        return new EventsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {
        final Events event = events.get(position);
        holder.onBind(event);


    }

    @Override
    public int getItemCount() {
        return events.size();
    }


     class EventsListViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView price;
        private TextView date;
        private TextView locale;
        private CheckBox checkBox;
        private TextView eventTime;





         public EventsListViewHolder(View itemView) {
             super(itemView);


             name = itemView.findViewById(R.id.event_name);
             price = itemView.findViewById(R.id.price);
             date = itemView.findViewById(R.id.date);
             locale = itemView.findViewById(R.id.locale);
             checkBox = itemView.findViewById(R.id.fav_box);
             eventTime = itemView.findViewById(R.id.event_time);

         }



         public void onBind(Events event){
             double max= 0 ;
             double min = 0;
             String currencyType = null;



             for (int i = 0; i < event.getPriceRanges().size() ; i++) {
                 max = event.getPriceRanges().get(i).getMax();
                 min = event.getPriceRanges().get(i).getMin();
                 currencyType = event.getPriceRanges().get(i).getCurrency();

             }

               dataUtility.parseTime(event.getDates().getStart().getLocalTime());

             name.setText(event.getName());
             price.setText(min + " - " + max + " "+ currencyType);
             date.setText(event.getDates().getStart().getLocalDate());
             eventTime.setText(event.getDates().getStart().getLocalTime());
             locale.setText(event.getLocale());


         }

     }

}