package com.company.electricitybillappp.api;

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application {

    private static Context context;

    public static Context getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
