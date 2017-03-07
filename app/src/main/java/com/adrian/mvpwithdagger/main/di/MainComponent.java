package com.adrian.mvpwithdagger.main.di;


import com.adrian.mvpwithdagger.app.di.AppComponent;
import com.adrian.mvpwithdagger.main.view.MainActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@MainScope
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
