package com.necer.example.api;


import necer.network.RxRetrofit;

public class Api {
    public static ApiService movieService;

    public static ApiService getDefaultService() {
        if (movieService == null) {
            movieService = RxRetrofit.getRetrofit().create(ApiService.class);
        }
        return movieService;
    }
}