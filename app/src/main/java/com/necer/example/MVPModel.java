package com.necer.example;

import io.reactivex.Observable;
import necer.network.Api;
import necer.network.RxFunction;
import necer.network.RxSchedulers;
import necer.network.bean.Calendar;

/**
 * Created by necer on 2017/6/29.
 */

public class MVPModel {

    public Observable<Calendar> getCalendar(String date) {
        return Api.getDefaultService().calendarBean(date).map(new RxFunction<Calendar>()).compose(RxSchedulers.<Calendar>io_main());
    }

}
