package com.necer.example;


import com.necer.example.bean.Calendar;

/**
 * Created by necer on 2017/6/29.
 */

public interface MVPView {

    void setResult(Calendar calendar);

    void onError(int whichRequest ,Throwable t);

    void onStartLoading(int whichRequest);

    void onEndLoading(int whichRequest);

}
