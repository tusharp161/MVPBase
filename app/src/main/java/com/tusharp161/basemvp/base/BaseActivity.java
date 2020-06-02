package com.tusharp161.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void close() {
        finish();
    }

    protected void initToolbar(final Toolbar toolbar, final boolean showNavigationButton, boolean showTitle) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showNavigationButton);
            getSupportActionBar().setDisplayShowTitleEnabled(showTitle);
        }
    }

    public void addFragment(Fragment fragment, int containerId) {
        addFragment(fragment, containerId, false, null);
    }

    public void addFragment(Fragment fragment, int containerId, boolean addToBackStack, String backStackName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(backStackName);
        }
        fragmentTransaction.commit();
    }
}
