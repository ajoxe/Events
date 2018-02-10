package com.example.android.events.roomdatabase;

import android.arch.persistence.room.TypeConverter;

import com.example.android.events.model.Classification;
import com.example.android.events.model.Images;
import com.example.android.events.model.PriceRanges;
import com.example.android.events.model.Products;
import com.example.android.events.model.VenueEmbedded;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by amirahoxendine on 2/9/18.
 */

public class DataConverter {


        /*Images list Converter*/
        @TypeConverter
        public String fromImagesList(List<Images> images) {
            if (images == null) {
                return (null);
            }
            Gson gson = new Gson();
            Type type = new TypeToken<List<Images>>() {
            }.getType();
            String json = gson.toJson(images, type);
            return json;
        }

        @TypeConverter
        public List<Images> toImagesList(String imagesString) {
            if (imagesString == null) {
                return (null);
            }
            Gson gson = new Gson();
            Type type = new TypeToken<List<Images>>() {
            }.getType();
            List<Images> imagesList = gson.fromJson(imagesString, type);
            return imagesList;
        }

    /*Classification list Converter*/
    @TypeConverter
    public String fromClassificationList(List<Classification> classifications) {
        if (classifications == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Classification>>() {
        }.getType();
        String json = gson.toJson(classifications, type);
        return json;
    }

    @TypeConverter
    public List<Classification> toClassificationList(String classificationString) {
        if (classificationString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Classification>>() {
        }.getType();
        List<Classification> classificationList = gson.fromJson(classificationString, type);
        return classificationList;
    }

    /*PriceRanges list Converter*/
    @TypeConverter
    public String fromPriceRangeList(List<PriceRanges> priceRanges) {
        if (priceRanges == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<PriceRanges>>() {
        }.getType();
        String json = gson.toJson(priceRanges, type);
        return json;
    }

    @TypeConverter
    public List<PriceRanges> toPriceRangesList(String priceRangesString) {
        if (priceRangesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<PriceRanges>>() {
        }.getType();
        List<PriceRanges> priceRangesList = gson.fromJson(priceRangesString, type);
        return priceRangesList;
    }

    /*Products list Converter*/
    @TypeConverter
    public String fromProductsList(List<Products> products) {
        if (products == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Products>>() {
        }.getType();
        String json = gson.toJson(products, type);
        return json;
    }

    @TypeConverter
    public List<Products> toProductsList(String productsString) {
        if (productsString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Images>>() {
        }.getType();
        List<Products> productsList = gson.fromJson(productsString, type);
        return productsList;
    }

    /*Venue Embedded list Converter*/
    @TypeConverter
    public String fromVenueEmbedded(VenueEmbedded venue_embedded) {
        if (venue_embedded == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<VenueEmbedded>() {
        }.getType();
        String json = gson.toJson(venue_embedded, type);
        return json;
    }

    @TypeConverter
    public VenueEmbedded toVenueEmbedded(String venueEmbeddedString) {
        if (venueEmbeddedString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<VenueEmbedded>() {
        }.getType();
        VenueEmbedded venueEmbedded = gson.fromJson(venueEmbeddedString, type);
        return venueEmbedded;
    }
}
