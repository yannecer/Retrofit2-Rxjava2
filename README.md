# Retrofit2-Rxjava2
对Retrofit2-Rxjava2联网的封装，针对一般的联网请求，弹窗，取消请求，页面关闭取消订阅

### 优点
```
1、尽可能简洁
2、可控制不同请求的加载框，
3、错误统一处理
4、页面销毁时取消订阅
5、可根据不同请求处理不同的异常
```

### 示例
```
 Api.getDefaultService()
                .calendarBean("2017-06-29")
                .map(new RxFunction<Calendar>())
                .compose(RxSchedulers.<Calendar>io_main())
                .subscribeWith(new RxObserver<Calendar>(this, TAG, 0, false) {
                    @Override
                    public void onSuccess(int whichRequest, Calendar calendar) {
                        tv_.setText(calendar.getLunar());
                    }

                    @Override
                    public void onError(int whichRequest, Throwable e) {

                    }
                });
```

#### 配合MVP效果更佳


###　详情参看：http://blog.csdn.net/y12345654321/article/details/73920581
