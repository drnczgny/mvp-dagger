package com.adrian.mvpwithdagger.omdb.di;


import com.adrian.mvpwithdagger.omdb.presenter.OmdbInteractor;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbInteractorImpl;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbPresenter;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbPresenterImpl;
import com.adrian.mvpwithdagger.omdb.service.OmdbApiService;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiActivity;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Module
public class OmdbModule {

    private OmdbApiActivity omdbApiActivity;

    private OmdbInteractor omdbInteractor;

    public OmdbModule(OmdbApiActivity omdbApiActivity) {
        this.omdbApiActivity = omdbApiActivity;
    }

    public OmdbModule(OmdbInteractor omdbInteractor) {
        this.omdbInteractor = omdbInteractor;
    }

    @Provides
    @OmdbScope
    public OmdbApiService provideOmdbService(Retrofit retrofit) {
        OmdbApiService omdbApiService = retrofit.create(OmdbApiService.class);
        return omdbApiService;
    }

    @Provides
    @OmdbScope
    OmdbInteractor provideOmdbInteractor() {
        return new OmdbInteractorImpl(provideOmdApiView());
    }

    @Provides
    @OmdbScope
    public OmdbPresenter provideOmdbPresenter() {
        return new OmdbPresenterImpl(provideOmdApiView(), provideOmdbInteractor());
    }

    @Provides
    @OmdbScope
    OmdbApiView provideOmdApiView() {
        return omdbApiActivity;
    }

}
