package com.necer.example;

import necer.network.bean.Calendar;

/**
 * Created by necer on 2017/6/29.
 */

public interface MVPView {
    void setResult(Calendar calendar);

    void onErrot(int whichRequest ,Throwable t);

    void onStartLoading(int whichRequest);

    void onEndLoading(int whichRequest);

}
