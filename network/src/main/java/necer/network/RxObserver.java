package necer.network;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *
 * Created by necer on 2017/6/28.
 */

public abstract class RxObserver<T> implements Observer<T> {


    private RxManager mRxManager;
    private int mWhichRequest;
    private String mKey;

    private boolean isShowDialog;
    private Dialog mDialog;


    public RxObserver(Context context,String key, int whichRequest,boolean isShowDialog) {

        this.mKey = key;
        this.isShowDialog = isShowDialog;
        this.mWhichRequest = whichRequest;
        mDialog = new ProgressDialog(context);
        mDialog.setTitle("请稍后");

        mRxManager = RxManager.getInstance();
    }


    @Override
    public final void onSubscribe(Disposable d) {
        mRxManager.add(mKey, d);
        if (isShowDialog) {
            mDialog.show();
        }
        onStart(mWhichRequest);
    }

    @Override
    public final void onNext(T value) {
        onSuccee(mWhichRequest, value);
    }

    @Override
    public final void onError(Throwable e) {

        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
        onError(mWhichRequest, e);
    }

    @Override
    public final void onComplete() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


    public abstract void onSuccee(int whichRequest ,T t);
    public abstract void onError(int whichRequest, Throwable e);

    public void onStart(int whichRequest) {

    }







}
