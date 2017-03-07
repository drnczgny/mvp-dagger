package com.adrian.mvpwithdagger.login.domain;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class LoggedUser {

    private String username;

    public LoggedUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "username='" + username + '\'' +
                '}';
    }
}
