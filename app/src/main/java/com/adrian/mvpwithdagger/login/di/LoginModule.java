package com.adrian.mvpwithdagger.login.di;


import com.adrian.mvpwithdagger.login.presenter.LoginInteractor;
import com.adrian.mvpwithdagger.login.presenter.LoginInteractorImpl;
import com.adrian.mvpwithdagger.login.presenter.LoginPresenter;
import com.adrian.mvpwithdagger.login.presenter.LoginPresenterImpl;
import com.adrian.mvpwithdagger.login.view.LoginActivity;
import com.adrian.mvpwithdagger.login.view.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 03. 06..
 */

@Module
public class LoginModule {

    private LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @LoginScope
    LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    @LoginScope
    LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl(provideLoginView(), provideLoginInteractor());
    }

    @Provides
    @LoginScope
    LoginView provideLoginView() {
        return loginActivity;
    }
}
