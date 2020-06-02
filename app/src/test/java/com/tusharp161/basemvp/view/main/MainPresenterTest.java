package com.tusharp161.basemvp.view.main;

import com.tusharp161.basemvp.base.BaseView;
import com.tusharp161.basemvp.domain.model.SampleEntity;
import com.tusharp161.basemvp.domain.usecase.SampleUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

public class MainPresenterTest {

    @InjectMocks
    private MainPresenter mainPresenter;

    @Mock
    private BaseView baseView;

    @Mock
    private SampleUseCase sampleUseCase;

    @Mock
    private SampleEntity sampleEntity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mainPresenter.bind(baseView);
    }

    @Test
    public void sampleUsecaseTest() {
        when(sampleUseCase.execute()).thenReturn(Observable.just(sampleEntity));
        mainPresenter.makeSampleUsecaseCall();

    }
}
