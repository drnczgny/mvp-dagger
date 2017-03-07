package com.adrian.mvpwithdagger.main.di;


import com.adrian.mvpwithdagger.main.presenter.MainPresenter;
import com.adrian.mvpwithdagger.main.presenter.MainPresenterImpl;
import com.adrian.mvpwithdagger.main.view.MainActivity;
import com.adrian.mvpwithdagger.main.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 06..
 */

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainScope
    MainPresenter provideMainPresenter() {
        return new MainPresenterImpl(provideMainView());
    }

    @Provides
    @MainScope
    MainView provideMainView() {
        return mainActivity;
    }
}
