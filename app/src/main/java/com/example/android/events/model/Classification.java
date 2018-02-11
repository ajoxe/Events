package com.example.android.events.model;




/**
 * Created by melg on 2/4/18.
 */

public class Classification {

    private Classification_Genre genre;
    private Classification_Segment segment;

    public Classification() {
    }

    public Classification_Genre getGenre() {
        return genre;
    }

    public void setGenre(Classification_Genre genre) {
        this.genre = genre;
    }

    public Classification_Segment getSegment() {
        return segment;
    }

    public void setSegment(Classification_Segment segment) {
        this.segment = segment;
    }
}
