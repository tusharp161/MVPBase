package com.tusharp161.basemvp.view.main;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tusharp161.basemvp.R;
import com.tusharp161.basemvp.base.BaseActivity;
import com.tusharp161.basemvp.base.BaseView;

import javax.inject.Inject;


import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity implements BaseView {

    @Inject
    Context application;

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.textViewTest)
    TextView sampleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sampleTextView.setText("Main!");
        Toast.makeText(application, "Dagger Test", Toast.LENGTH_LONG).show();
        mainPresenter.makeSampleUsecaseCall();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.unbind();
    }
}
