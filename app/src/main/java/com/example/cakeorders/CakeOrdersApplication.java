package com.example.cakeorders;

import android.app.Application;
import android.content.Context;

public class CakeOrdersApplication extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
