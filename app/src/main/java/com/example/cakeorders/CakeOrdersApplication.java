package com.example.cakeorders;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class CakeOrdersApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public void onCreate(){
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
