package com.example.android.events.roomdatamodels;

import com.example.android.events.model.Images;

import java.util.ArrayList;
import java.util.List;

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
}
