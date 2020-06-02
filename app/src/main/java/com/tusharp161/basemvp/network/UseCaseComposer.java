package com.tusharp161.basemvp.network;

import io.reactivex.ObservableTransformer;

public interface UseCaseComposer {

    <T> ObservableTransformer<T, T> apply();
}
