package com.adrian.mvpwithdagger.omdb.presenter;

/**
 * Created by Adrian_Czigany on 3/2/2017.
 */

public interface OmdbPresenter {

    void findAllMovie();

    void findMovieByTitle(final String title);

    void findMovieByYear(final int year);

}
