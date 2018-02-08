package com.example.android.events.roomdatamodels;

import android.arch.persistence.room.Entity;

import com.example.android.events.model.Images;

/**
 * Created by amirahoxendine on 2/6/18.
 */
@Entity
public class ImageRoomEntity {

        private boolean fallback;
        private int height;
        private int width;
        private String url;
        private String ratio;
        public String eventID;



        public String getEventID() {
            return eventID;
        }

        public void setEventID(String eventID) {
            this.eventID = eventID;
        }

        public boolean getFallback() {
            return fallback;
        }

        public void setFallback(boolean fallback) {
            this.fallback = fallback;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }

}
