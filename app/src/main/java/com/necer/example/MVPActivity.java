package com.necer.example;

import android.view.View;
import android.widget.TextView;

import com.necer.example.bean.Calendar;


/**
 * Created by necer on 2017/6/29.
 */

public class MVPActivity extends BaseActivity implements MVPView{

    TextView tv_;
    private MVPPresenter mvpPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initData() {
        tv_ = (TextView) findViewById(R.id.tv_);
        mvpPresenter = new MVPPresenter(this);
    }

    public void request(View view) {
        mvpPresenter.getCalendar(this, "2018-10-01", TAG, 0, false);
    }

    @Override
    public void setResult(Calendar calendar) {
        tv_.setText(calendar.getWeekday());
    }

    /**
     * 如果有多个请求可根据whichRequest处理不同请求的异常
     * @param whichRequest
     * @param t
     */
    @Override
    public void onError(int whichRequest, Throwable t) {

    }

    /**
     * 如果不使用RxObserver自带的Dialog，可以在RxObserver中设置false，
     * 在onStartLoading和onEndLoading设置需要其他dialog的显示和消失，如SwipeRefreshLayout
     * @param whichRequest
     */
    @Override
    public void onStartLoading(int whichRequest) {

    }

    @Override
    public void onEndLoading(int whichRequest) {

    }
}
