package com.tusharp161.basemvp.view.main;

import android.util.Log;

import com.tusharp161.basemvp.base.BasePresenter;
import com.tusharp161.basemvp.base.BaseView;
import com.tusharp161.basemvp.domain.usecase.SampleUseCase;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<BaseView> {

    private final SampleUseCase sampleUseCase;

    @Inject
    public MainPresenter(SampleUseCase sampleUseCase) {
        this.sampleUseCase = sampleUseCase;
    }

    void makeSampleUsecaseCall() {
        sampleUseCase.execute().compose(bindToLifecycle()).subscribe(sampleEntity -> {
            Log.d("Usecase Test:>>>> ", sampleEntity.getSampleString());
        }, throwable -> {

        });
    }
}
