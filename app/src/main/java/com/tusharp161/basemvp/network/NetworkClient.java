package com.tusharp161.basemvp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkClient {

    private final String BASE_URL = "";
    private Retrofit retrofit;
    private static NetworkClient client;

    public static NetworkClient getInstance() {
        if (client == null) {
            client = new NetworkClient();
        }
        return client;
    }

    public <T> T create(final Class<T> service) {
        if (retrofit == null) {
            retrofit = createRetrofit();
        }
        return retrofit.create(service);
    }

    private Retrofit createRetrofit() {
        OkHttpClient okHttpClient = getHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    private OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true);
        builder.readTimeout(1, TimeUnit.MINUTES);
        builder.writeTimeout(1, TimeUnit.MINUTES);
        builder.connectTimeout(1, TimeUnit.MINUTES);
        return builder.build();
    }
}
