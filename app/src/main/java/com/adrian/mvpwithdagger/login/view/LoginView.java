package com.adrian.mvpwithdagger.login.view;

/**
 * Created by Adrian_Czigany on 2/28/2017.
 */

public interface LoginView {

    void showProgressBar();

    void hideProgressBar();

    void errorOnUsername();

    void errorOnPassword();

    void credentialsVerified();

    void navigateToMain();

}
