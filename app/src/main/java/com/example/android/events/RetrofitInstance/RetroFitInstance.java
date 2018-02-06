package com.example.android.events.RetrofitInstance;

import com.example.android.events.backend.TicketMasterService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by melg on 2/4/18.
 */

public class RetroFitInstance {

    private String HOST = "https://app.ticketmaster.com/";

    public static RetroFitInstance instance;


    public RetroFitInstance() {

    }


    public static RetroFitInstance getInstance() {
        if (instance == null) {
            instance = new RetroFitInstance();
        }
        return instance;
    }



    Retrofit getRetrofit() { // getting the retofit builder to use in other methods
        return new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    public TicketMasterService getApi() {
       return getRetrofit().create(TicketMasterService.class);
    }


}
