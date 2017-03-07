package com.adrian.mvpwithdagger.omdb.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.adrian.mvpwithdagger.R;
import com.adrian.mvpwithdagger.app.MyApp;
import com.adrian.mvpwithdagger.omdb.di.DaggerOmdbComponent;
import com.adrian.mvpwithdagger.omdb.di.OmdbComponent;
import com.adrian.mvpwithdagger.omdb.di.OmdbModule;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbPresenter;
import com.adrian.mvpwithdagger.omdb.service.OmdbApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OmdbApiActivity extends AppCompatActivity implements OmdbApiView {

    private static final String TAG = OmdbApiActivity.class.getName();

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    @BindView(R.id.btnFindByYear)
    Button btnFindByYear;

    @BindView(R.id.btnFindByTitle)
    Button btnFindByTitle;

    @BindView(R.id.btnFindByBoth)
    Button btnFindByBoth;

    @Inject
    OmdbPresenter omdbPresenter;

    @Inject
    OmdbApiService omdbApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb_api);

        ButterKnife.bind(this);

        OmdbComponent omdbComponent = DaggerOmdbComponent.builder()
                .omdbModule(new OmdbModule(this))
                .appComponent(MyApp.get(this).getAppComponent())
                .build();
        omdbComponent.inject(this);

        omdbApiService.toString();
    }

    @OnClick(R.id.btnFindByYear)
    public void onClickBtnFindByYear() {
        omdbPresenter.findMovieByYear(2010);
    }

    @OnClick(R.id.btnFindByTitle)
    public void onClickBtnFindByTitle() {
        omdbPresenter.findMovieByTitle("Superman");
    }

    @OnClick(R.id.btnFindByBoth)
    public void onClickBtnFindByBoth() {
        omdbPresenter.findMovieByYear(2010);
        omdbPresenter.findMovieByTitle("Superman");
    }

    @Override
    public void test() {
        Log.i(TAG, " OK test !!! ");
    }
}
