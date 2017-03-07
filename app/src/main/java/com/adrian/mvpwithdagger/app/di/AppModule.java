package com.adrian.mvpwithdagger.app.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.adrian.mvpwithdagger.app.MyApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@Module
public class AppModule {

    private final MyApp myApp;

    public AppModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @AppScope
    @Provides
    public Context providesApplicationContext() {
        return myApp;
    }

    @AppScope
    @Provides
    public SharedPreferences provideSharedPreferences(Context app) {
        return app.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
    }


}
