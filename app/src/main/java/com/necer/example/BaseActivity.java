package com.necer.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import necer.network.MyLog;
import necer.network.RxManager;

/**
 * Created by necer on 2017/6/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        TAG = getPackageName() + "." + getClass().getSimpleName();
        MyLog.d("TAG::" + TAG);
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxManager.getInstance().clear(TAG);
    }
}



