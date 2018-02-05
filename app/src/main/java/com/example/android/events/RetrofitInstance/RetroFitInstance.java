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


    public static RetroFitInstance getInstance() { //if retrofit instance is available - use it. if not , create a another retrofit builder.

        if (instance != null) {
            instance = new RetroFitInstance();
        }
        return instance;
    }

    public static void setInstance(RetroFitInstance instance) { // setting the same instance of the retrofit
        RetroFitInstance.instance = instance;
    }


    Retrofit getRetrofit() { // getting the retofit builder to use in other methods
        return new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    TicketMasterService getApi() {
       return getRetrofit().create(TicketMasterService.class);
    }


}
