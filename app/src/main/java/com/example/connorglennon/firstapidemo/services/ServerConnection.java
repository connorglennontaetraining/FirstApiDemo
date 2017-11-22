package com.example.connorglennon.firstapidemo.services;

import com.example.connorglennon.firstapidemo.util.constants.ApiList;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Connor Glennon on 22/11/2017.
 */

public class ServerConnection {
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static RequestInterface getServerConnection()
    {
        retrofit = new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(ApiList.BASE_URL).build();

        return retrofit.create(RequestInterface.class);
    }
}
