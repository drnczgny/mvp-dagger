package com.adrian.mvpwithdagger.main.presenter;

import com.adrian.mvpwithdagger.main.view.MainView;
/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setUpNavDrawer() {
        mainView.setUpNavDrawer();
    }


}
