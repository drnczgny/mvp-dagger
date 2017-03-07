package com.adrian.mvpwithdagger.omdb.di;


import com.adrian.mvpwithdagger.app.di.AppComponent;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbInteractorImpl;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbPresenterImpl;
import com.adrian.mvpwithdagger.omdb.service.OmdbApiService;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Component(dependencies = AppComponent.class, modules = {OmdbModule.class})
@OmdbScope
public interface OmdbComponent {

    OmdbApiService omdbApiService();

    void inject(OmdbApiActivity omdbApiActivity);

    void inject(OmdbInteractorImpl omdbInteractorImpl);

    void inject(OmdbPresenterImpl omdbPresenterImpl);

}
