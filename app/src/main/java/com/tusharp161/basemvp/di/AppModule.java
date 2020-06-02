package com.tusharp161.basemvp.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;

import com.tusharp161.basemvp.network.AndroidUseCaseComposer;
import com.tusharp161.basemvp.network.NetworkClient;
import com.tusharp161.basemvp.network.UseCaseComposer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    @Provides
    @Singleton
    Context provideContext(Application application) {
        this.context = application;
        return context;
    }

    @Provides
    UseCaseComposer provideUseCaseComposer() {
        return new AndroidUseCaseComposer();
    }

    @Provides
    @Singleton
    NetworkClient provideNetworkClient() {
        return NetworkClient.getInstance();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AssetManager provideAssetManager() {
        return context.getAssets();
    }


}
