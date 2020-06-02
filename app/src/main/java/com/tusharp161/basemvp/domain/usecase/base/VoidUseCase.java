package com.tusharp161.basemvp.domain.usecase.base;


import com.tusharp161.basemvp.network.UseCaseComposer;

import io.reactivex.Observable;

public abstract class VoidUseCase<R> extends UseCase<Void, R> {
    protected VoidUseCase(UseCaseComposer useCaseComposer) {
        super(useCaseComposer);
    }

    protected abstract Observable<R> createUseCaseObservable();

    public Observable<R> execute() {
        return execute(null);
    }

    @Override
    protected Observable<R> createUseCaseObservable(Void param) {
        return createUseCaseObservable();
    }
}