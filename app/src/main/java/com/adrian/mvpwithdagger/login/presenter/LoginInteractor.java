package com.adrian.mvpwithdagger.login.presenter;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void validateLoginCredentials(final String username, final String password, final OnLoginFinishedListener onLoginFinishedListener);

}
