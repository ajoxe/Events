package com.example.android.events.model;


public class Dates {

    private boolean spanMultipleDays;
    private Status status;
    private String timezone;
    private Start start;

    public boolean getSpanMultipleDays() {
        return spanMultipleDays;
    }

    public void setSpanMultipleDays(boolean spanMultipleDays) {
        this.spanMultipleDays = spanMultipleDays;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }
}
