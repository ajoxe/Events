package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;


import com.example.android.events.model.Classification;
import com.example.android.events.model.Dates;
import com.example.android.events.model.Images;
import com.example.android.events.model.PriceRanges;
import com.example.android.events.model.Products;
import com.example.android.events.model.Seatmap;
import com.example.android.events.model.Start;
import com.example.android.events.model.Status;
import com.example.android.events.model.VenueEmbedded;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by amirahoxendine on 2/6/18.
 */
@Entity(tableName = "events")
public class EventsRoomEntity {
    //@Embedded(prefix = "foo_")- prefix for embedded objects with the same name.
    //can embed dates.
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String id;
    private String status;
    private String pleaseNote;
    private String info;
    private String locale;
    private String url;
    private String type;
    private String name;

    @Embedded
    private Dates dates;
    @Embedded
    private Seatmap seatmap;
    @TypeConverters(DataConverter.class)
    private List<Images> images;
    @TypeConverters(DataConverter.class)
    private List<Products> products;
    @TypeConverters(DataConverter.class)
    private List<PriceRanges> priceRanges;
    @TypeConverters(DataConverter.class)
    private List<Classification> classifications;
    @TypeConverters(DataConverter.class)
    private VenueEmbedded _embedded;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Seatmap getSeatmap() {
        return seatmap;
    }

    public void setSeatmap(Seatmap seatmap) {
        this.seatmap = seatmap;
    }

    public String getPleaseNote() {
        return pleaseNote;
    }

    public void setPleaseNote(String pleaseNote) {
        this.pleaseNote = pleaseNote;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TypeConverters(DataConverter.class)
    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
    @TypeConverters(DataConverter.class)
    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
    @TypeConverters(DataConverter.class)
    public List<PriceRanges> getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(List<PriceRanges> priceRanges) {
        this.priceRanges = priceRanges;
    }
    @TypeConverters(DataConverter.class)
    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }
    @TypeConverters(DataConverter.class)
    public VenueEmbedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(VenueEmbedded _embedded) {
        this._embedded = _embedded;
    }
}
