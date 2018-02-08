package com.example.android.events.roomdatabase;

/**
 * Created by amirahoxendine on 2/6/18.
 */

public class EventsRoomDataUtility {
    /*public ImageRoomEntity(Images image){
        fallback = image.getFallback();
        height= image.getHeight();
        width = image.getWidth();
        url = image.getUrl();
        ratio = image.getUrl();
    }*/


    /*Adds id's for relations'*//*
    public List<ImageRoomEntity> addIdsToImages(List<Images> pojoImages){
        images = new ArrayList<>();
        for (Images image: pojoImages){
            ImageRoomEntity roomImage = new ImageRoomEntity(image);
            roomImage.setEventID(this.id);
            images.add(roomImage);
        }
        return images;
    }*/

   /* public EventsRoomEntity(Events event){
        this.id = event.getId();
        this.name = event.getName();
        this.type = event.getType();
        this.url = event.getUrl();
        this.locale = event.getLocale();
        this.info = event.getInfo();
        this.pleaseNote = event.getPleaseNote();
        this.seatmapImage = event.getSeatmap().getStaticUrl();
        this.date_spanMultipleDays = event.getDates().getSpanMultipleDays();
        this.date_status = event.getDates().getStatus();
        this.date_timezone = event.getDates().getTimezone();
        this.date_start = event.getDates().getStart();
        this.price_max = event.getPriceRanges().get(0).getMax();
        this.price_min = event.getPriceRanges().get(0).getMin();
        this.price_currency = event.getPriceRanges().get(0).getCurrency();
        this.price_type = event.getPriceRanges().get(0).getType();
        parseClassifications(event.getClassifications());
    }*/
}
