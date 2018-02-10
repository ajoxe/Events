package com.example.android.events.model;

import java.util.List;

/**
 * Created by melg on 2/4/18.
 */

public class VenueEmbedded {
    private List<Venue> venues;
    private List<Attractions> attractions;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }



    public List<Attractions> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attractions> attractions) {
        this.attractions = attractions;
    }



}
