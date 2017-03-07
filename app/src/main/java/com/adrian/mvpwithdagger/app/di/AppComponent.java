package com.adrian.mvpwithdagger.app.di;

import android.content.SharedPreferences;

import com.adrian.mvpwithdagger.app.MyApp;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    SharedPreferences sharedPreferences();

    void inject(MyApp myApp);

}
