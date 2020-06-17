package com.example.enjoy.rxjava_derry;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {

    private static CustomApplication customApplication;


    public static Context getInstance(){
        return customApplication.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

}
