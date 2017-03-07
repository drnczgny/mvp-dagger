package com.adrian.mvpwithdagger.app.di;

import android.content.SharedPreferences;

import com.adrian.mvpwithdagger.app.MyApp;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    SharedPreferences sharedPreferences();

    Retrofit retrofit();

    void inject(MyApp myApp);

}
