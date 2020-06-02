package com.tusharp161.basemvp.domain.usecase;

import com.tusharp161.basemvp.domain.model.SampleEntity;
import com.tusharp161.basemvp.domain.usecase.base.VoidUseCase;
import com.tusharp161.basemvp.network.UseCaseComposer;

import javax.inject.Inject;

import io.reactivex.Observable;

public class SampleUseCase extends VoidUseCase<SampleEntity> {

    @Inject
    protected SampleUseCase(UseCaseComposer useCaseComposer) {
        super(useCaseComposer);
    }

    @Override
    protected Observable<SampleEntity> createUseCaseObservable() {
        return Observable.just(new SampleEntity());
    }
}
