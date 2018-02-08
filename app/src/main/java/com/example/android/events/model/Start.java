package com.example.android.events.model;


public class Start {
    private boolean noSpecificTime;
    private boolean timeTBA;
    private boolean dateTBA;
    private boolean dateTBD;
    private String dateTime;
    private String localTime;
    private String localDate;

    public boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    public void setNoSpecificTime(boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
    }

    public boolean getTimeTBA() {
        return timeTBA;
    }

    public void setTimeTBA(boolean timeTBA) {
        this.timeTBA = timeTBA;
    }

    public boolean getDateTBA() {
        return dateTBA;
    }

    public void setDateTBA(boolean dateTBA) {
        this.dateTBA = dateTBA;
    }

    public boolean getDateTBD() {
        return dateTBD;
    }

    public void setDateTBD(boolean dateTBD) {
        this.dateTBD = dateTBD;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
}
