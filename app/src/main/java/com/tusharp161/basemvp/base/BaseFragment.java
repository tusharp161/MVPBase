package com.tusharp161.basemvp.base;

import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseFragment extends RxFragment implements BaseView {


    @Override
    public void close() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
