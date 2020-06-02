package com.tusharp161.basemvp.base;

import android.support.annotation.NonNull;

import com.tusharp161.basemvp.rxlifecycle.PresenterEvent;
import com.tusharp161.basemvp.rxlifecycle.RxLifecyclePresenter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class BasePresenter<V extends BaseView> implements LifecycleProvider<Integer> {

    private final BehaviorSubject<Integer> lifecycleSubject
            = BehaviorSubject.create();

    protected V view;

    protected void onBind() {

    }

    protected void onUnbind() {

    }

    public final void bind(V viewToBind) {
        view = viewToBind;
        onBind();
        lifecycleSubject.onNext(PresenterEvent.ATTACH);
    }

    public final void unbind() {
        onUnbind();
        lifecycleSubject.onNext(PresenterEvent.DETACH);
        view = null;
    }

    @Override
    @NonNull
    public Observable<Integer> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    public <T> LifecycleTransformer<T> bindUntilEvent(@NonNull Integer event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecyclePresenter.bindPresenter(lifecycleSubject);
    }
}
