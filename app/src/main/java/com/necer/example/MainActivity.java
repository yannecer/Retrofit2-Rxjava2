package com.necer.example;

import android.view.View;

import necer.network.Api;
import necer.network.MyLog;
import necer.network.RxFunction;
import necer.network.RxObserver;
import necer.network.RxSchedulers;
import necer.network.bean.Calendar;

public class MainActivity extends BaseActivity {



    public void json(View view) {

        Api.getDefaultService()
                .calendarJson("2017-06-29")
                .compose(RxSchedulers.<String>io_main())
                .subscribeWith(new RxObserver<String>(this, TAG, 0, true) {
                    @Override
                    public void onSuccee(int whichRequest, String s) {
                        MyLog.d("ssss::" + s);
                    }
                    @Override
                    public void onError(int whichRequest, Throwable e) {

                    }

                });
    }

    public void bean(View view) {
        Api.getDefaultService()
                .calendarBean("2017-06-29")
                .map(new RxFunction<Calendar>())
                .compose(RxSchedulers.<Calendar>io_main())
                .subscribeWith(new RxObserver<Calendar>(this, TAG, 0, false) {
                    @Override
                    public void onStart(int whichRequest) {
                        super.onStart(whichRequest);

                    }

                    @Override
                    public void onSuccee(int whichRequest, Calendar calendar) {
                        MyLog.d("calendar::" + calendar.getLunar());

                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {

                    }

                });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
