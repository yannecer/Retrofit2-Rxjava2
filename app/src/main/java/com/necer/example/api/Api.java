package com.necer.example.api;


import necer.network.RxRetrofit;

public class Api {
    public static ApiService movieService;

    public static final String BASE_URL = "Http://apicloud.mob.com/appstore/calendar/";


    public static ApiService getDefaultService() {
        if (movieService == null) {
            movieService = RxRetrofit.getRetrofit(BASE_URL).create(ApiService.class);
        }
        return movieService;
    }
}