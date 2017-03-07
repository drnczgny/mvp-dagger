package com.adrian.mvpwithdagger.app;

import android.app.Activity;
import android.app.Application;

import com.adrian.mvpwithdagger.app.di.AppComponent;
import com.adrian.mvpwithdagger.app.di.AppModule;
import com.adrian.mvpwithdagger.app.di.DaggerAppComponent;


/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MyApp extends Application {

    AppComponent appComponent;

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
