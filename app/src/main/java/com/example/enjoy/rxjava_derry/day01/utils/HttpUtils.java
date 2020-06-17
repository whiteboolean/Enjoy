package com.example.enjoy.rxjava_derry.day01.utils;

import android.util.TimeUtils;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static final String TAG = "HttpUtils";

    private static final String baseUrl = "https://www.wanandroid.com/";

    public static String getBaseUrl() {
        return baseUrl;
    }


    /**
     *
     * @return 返回创建好的retrofit
     */
    public static Retrofit getOnlineCookieRetrofit(){
        OkHttpClient.Builder builder  = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder
                .addNetworkInterceptor(new StethoInterceptor())
                .readTimeout(10000, TimeUnit.SECONDS)
                .connectTimeout(10000,TimeUnit.SECONDS)
                .writeTimeout(10000,TimeUnit.SECONDS)
                .build();


        return new Retrofit.Builder().baseUrl(getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //请求用okhttp
    }


}
