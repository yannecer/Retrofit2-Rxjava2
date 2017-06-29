package com.necer.example.api;

import com.necer.example.bean.Calendar;

import io.reactivex.Observable;
import necer.network.HttpResult;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by necer on 2017/6/28.
 */

public interface ApiService {

    //日历
    @GET("day?key=1863a50c31d7c")
    Observable<String> calendarJson(@Query("date") String date);

    @GET("day?key=1863a50c31d7c")
    Observable<HttpResult<Calendar>> calendarBean(@Query("date") String date);


}
