package com.adrian.mvpwithdagger.login.presenter;

import android.content.SharedPreferences;

/**
 * Created by Adrian_Czigany on 2/28/2017.
 */

public interface LoginPresenter {

    void validateCredentials(final String username, final String password);

    void saveCredentialsToSharedPreferences(final SharedPreferences sharedPreferences, final String username);

}
