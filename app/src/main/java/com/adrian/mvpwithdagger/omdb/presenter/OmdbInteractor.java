package com.adrian.mvpwithdagger.omdb.presenter;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public interface OmdbInteractor {

    void findAllMovie();

    void findMovieByTitle(final String title);

    void findMovieByYear(final int year);

}
