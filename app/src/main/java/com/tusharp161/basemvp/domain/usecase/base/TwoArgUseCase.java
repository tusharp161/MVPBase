package com.tusharp161.basemvp.domain.usecase.base;


import com.tusharp161.basemvp.network.UseCaseComposer;

import io.reactivex.Observable;

public abstract class TwoArgUseCase<F, S, R> extends UseCase<TwoArgUseCase.Pair<F, S>, R> {


    protected TwoArgUseCase(UseCaseComposer useCaseComposer) {
        super(useCaseComposer);
    }

    protected abstract Observable<R> createUseCaseObservable(F first, S second);

    public Observable<R> execute(final F first, final S second) {
        return super.execute(new Pair<F, S>(first, second));
    }

    @Override
    protected Observable<R> createUseCaseObservable(Pair<F, S> param) {
        return createUseCaseObservable(param.first, param.second);
    }

    protected static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}
