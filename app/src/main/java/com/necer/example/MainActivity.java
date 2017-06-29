package com.necer.example;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import necer.network.Api;
import necer.network.RxFunction;
import necer.network.RxObserver;
import necer.network.RxSchedulers;
import necer.network.bean.Calendar;

public class MainActivity extends BaseActivity {


    TextView tv_;

    @Override
    protected void initData() {
        tv_ = (TextView) findViewById(R.id.tv_);
    }

    public void json(View view) {
        Api.getDefaultService()
                .calendarJson("2017-06-29")
                .compose(RxSchedulers.<String>io_main())
                .subscribeWith(new RxObserver<String>(this, TAG, 0, true) {
                    @Override
                    public void onSuccee(int whichRequest, String s) {
                        tv_.setText(s);
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
                        tv_.setText(calendar.getLunar());
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {

                    }
                });
    }

    public void mvp(View view) {

        startActivity(new Intent(this, MVPActivity.class));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
