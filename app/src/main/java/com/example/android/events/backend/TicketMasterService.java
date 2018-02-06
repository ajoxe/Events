package com.example.android.events.backend;

import com.example.android.events.model.EventWrapper;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by melg on 2/4/18.
 */

public interface TicketMasterService {
    @GET("discovery/v2/events.json?countryCode=US&apikey=ilPwBsnGTyoWc7GwITtkyAPPNMUOtqiS")
    List<EventWrapper> getEventResponse(@Query("US") String countryCode);


    @GET("/discovery/v2/events/{id}&apikey=ilPwBsnGTyoWc7GwITtkyAPPNMUOtqiS")
    List<EventWrapper> getEventIDResponse(@Path("id") String id); // finds event based on ID


    @GET("/discovery/v2/events/{id}/images&apikey=ilPwBsnGTyoWc7GwITtkyAPPNMUOtqiS")
    List<EventWrapper> getEventImageResponse(@Path("id") String id); // Grabs images for a specific Event


    @GET("/discovery/v2/classifications/{id}&apikey=ilPwBsnGTyoWc7GwITtkyAPPNMUOtqiS")
    List<EventWrapper> getEventGenre(@Path("id") String Genre); // Grabs images for a specific Event



}

