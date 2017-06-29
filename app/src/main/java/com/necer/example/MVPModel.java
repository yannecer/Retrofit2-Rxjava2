package com.necer.example;

import com.necer.example.api.Api;
import com.necer.example.bean.Calendar;

import io.reactivex.Observable;
import necer.network.RxFunction;
import necer.network.RxSchedulers;

/**
 * Created by necer on 2017/6/29.
 */

public class MVPModel {

    public Observable<Calendar> getCalendar(String date) {
        return Api.getDefaultService().calendarBean(date).map(new RxFunction<Calendar>()).compose(RxSchedulers.<Calendar>io_main());
    }

}
