package com.example.android.events.roomdatamodels;



import android.arch.persistence.room.Entity;

import com.example.android.events.model.Images;

import java.util.List;

/**
 * Created by melg on 2/4/18.
 */
@Entity
public class VenueRoomEntity {


    private _links _links;
    private UpcomingEvents upcomingEvents;
    private GeneralInfo generalInfo;
    private String parkingDetail;
    private BoxOfficeInfo boxOfficeInfo;
    private Social social;
    private Location location;
    private Address address;
    private Country country;
    private State state;
    private City city;
    private String timezone;
    private String postalCode;
    private List<Images> images;
    private String locale;
    private String url;

    private String id;
    private String type;
    private String name;

    public _links get_links() {
        return _links;
    }

    public void set_links(_links _links) {
        this._links = _links;
    }

    public UpcomingEvents getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(UpcomingEvents upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public String getParkingDetail() {
        return parkingDetail;
    }

    public void setParkingDetail(String parkingDetail) {
        this.parkingDetail = parkingDetail;
    }

    public BoxOfficeInfo getBoxOfficeInfo() {
        return boxOfficeInfo;
    }

    public void setBoxOfficeInfo(BoxOfficeInfo boxOfficeInfo) {
        this.boxOfficeInfo = boxOfficeInfo;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static class Location {}

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static class _links {
        private Self self;

        public Self getSelf() {
            return self;
        }

        public void setSelf(Self self) {
            this.self = self;
        }
    }

    public static class Self {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public static class UpcomingEvents {
    }

    public static class GeneralInfo {
    }

    public static class BoxOfficeInfo {
    }

    public static class Social {
        private Twitter twitter;

        public Twitter getTwitter() {
            return twitter;
        }

        public void setTwitter(Twitter twitter) {
            this.twitter = twitter;
        }
    }

    public static class Twitter {
        private String handle;

        public String getHandle() {
            return handle;
        }

        public void setHandle(String handle) {
            this.handle = handle;
        }
    }


    public static class Address {
    }

    public static class Country {
    }

    public static class State {
    }

    public static class City {
    }
}
