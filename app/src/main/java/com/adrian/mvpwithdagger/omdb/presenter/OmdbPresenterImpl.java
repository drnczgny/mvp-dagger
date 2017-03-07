package com.adrian.mvpwithdagger.omdb.presenter;


import com.adrian.mvpwithdagger.omdb.view.OmdbApiView;

/**
 * Created by Adrian_Czigany on 3/2/2017.
 */

public class OmdbPresenterImpl implements OmdbPresenter {

    private OmdbApiView omdbApiView;
    private OmdbInteractor omdbInteractor;

    public OmdbPresenterImpl(OmdbApiView omdbApiView, OmdbInteractor omdbInteractor) {
        this.omdbApiView = omdbApiView;
        this.omdbInteractor = omdbInteractor;
    }

    @Override
    public void findAllMovie() {
        omdbInteractor.findAllMovie();
    }

    @Override
    public void findMovieByTitle(String title) {
        omdbInteractor.findMovieByTitle(title);
    }

    @Override
    public void findMovieByYear(int year) {
        omdbInteractor.findMovieByYear(year);
        omdbApiView.test();
    }

}
