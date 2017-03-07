package com.adrian.mvpwithdagger.login.di;


import com.adrian.mvpwithdagger.app.di.AppComponent;
import com.adrian.mvpwithdagger.login.view.LoginActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 03. 06..
 */

@LoginScope
@Component(dependencies = AppComponent.class, modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
