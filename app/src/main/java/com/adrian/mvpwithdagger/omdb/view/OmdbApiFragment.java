package com.adrian.mvpwithdagger.omdb.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adrian.mvpwithdagger.R;
import com.adrian.mvpwithdagger.omdb.presenter.OmdbPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OmdbApiFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    @BindView(R.id.btnFindByYear)
    Button btnFindByYear;

    @BindView(R.id.btnFindByTitle)
    Button btnFindByTitle;

    @BindView(R.id.btnFindByBoth)
    Button btnFindByBoth;

//    @Inject
//    OmdbApiService omdbApiService;

    private OmdbPresenter omdbPresenter;

//    @Inject
//    @Named("OmdbPresenterImpl")
//    OmdbPresenterImpl omdbPresenter;

    public OmdbApiFragment() {
    }

    public static OmdbApiFragment newInstance() {
        OmdbApiFragment fragment = new OmdbApiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_omdb_api, container, false);

        ButterKnife.bind(this, view);

//        ((MyApp) getActivity().getApplication()).getAppComponent().inject(this);

//        DaggerOmdbComponent.builder()
//                .omdbModule(new OmdbModule(this))
//                .appComponent(MyApp.get(this).getAppComponent())
//                .build();

//        omdbPresenter = new OmdbPresenterImpl(this, omdbApiService);

        return view;
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }


}
