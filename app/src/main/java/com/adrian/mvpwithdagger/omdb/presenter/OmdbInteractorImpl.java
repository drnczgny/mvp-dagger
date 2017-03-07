package com.adrian.mvpwithdagger.omdb.presenter;

import android.util.Log;

import com.adrian.mvpwithdagger.app.MyApp;
import com.adrian.mvpwithdagger.omdb.di.DaggerOmdbComponent;
import com.adrian.mvpwithdagger.omdb.di.OmdbComponent;
import com.adrian.mvpwithdagger.omdb.di.OmdbModule;
import com.adrian.mvpwithdagger.omdb.service.OmdbApiService;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiActivity;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public class OmdbInteractorImpl implements OmdbInteractor {

    private static final String TAG = OmdbInteractorImpl.class.getName();

    private OmdbApiView omdbApiView;

    @Inject
    OmdbApiService omdbApiService;

    public OmdbInteractorImpl(OmdbApiView omdbApiView) {
        this.omdbApiView = omdbApiView;

        OmdbComponent omdbComponent = DaggerOmdbComponent.builder()
                .omdbModule(new OmdbModule(this))
                .appComponent(MyApp.get((OmdbApiActivity)omdbApiView).getAppComponent())
                .build();
        omdbComponent.inject(this);

        omdbApiService.toString();
    }

    @Override
    public void findAllMovie() {
        Call<String> call = omdbApiService.findAllMovie();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

    @Override
    public void findMovieByYear(final int year) {

        Map<String, Integer> data = new HashMap<>();
        data.put("y", year);

        Call<String> call = omdbApiService.findMovieByYear(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
                // Log error here since request failed
            }
        });
    }

    @Override
    public void findMovieByTitle(final String title) {

        Map<String, String> data = new HashMap<>();
        data.put("t", title);

        Call<String> call = omdbApiService.findMovieByTitle(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
                // Log error here since request failed
            }
        });
    }

}
