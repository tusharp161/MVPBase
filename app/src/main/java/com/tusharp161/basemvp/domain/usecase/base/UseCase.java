package com.tusharp161.basemvp.domain.usecase.base;


import com.tusharp161.basemvp.network.UseCaseComposer;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Action;

public abstract class UseCase<P, R> {

    protected final UseCaseComposer useCaseComposer;
    protected final Map<P, Observable<R>> observablesMap = new HashMap<>();

    protected UseCase(UseCaseComposer useCaseComposer) {
        this.useCaseComposer = useCaseComposer;
    }

    protected abstract Observable<R> createUseCaseObservable(final P param);

    public Observable<R> execute(final P param) {

        Observable<R> observable = observablesMap.get(param);
        if (observable == null) {
            try {
                observable = createUseCaseObservable(param);
            } catch (Exception e) {
                observable = Observable.error(e);
            }

            if (useCaseComposer != null) {
                observable = observable.compose(useCaseComposer.apply());
            }
            observable = observable.doOnDispose(new OnTerminateAction(param));
            observablesMap.put(param, observable);
        }
        return observable;
    }

    private class OnTerminateAction implements Action {

        private P param;

        public OnTerminateAction(P param) {
            this.param = param;
        }

        @Override
        public void run() throws Exception {
            observablesMap.remove(param);
        }
    }
}
