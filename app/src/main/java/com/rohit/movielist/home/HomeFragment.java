package com.rohit.movielist.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.rohit.movielist.R;
import com.rohit.movielist.base.BaseFragment;
import com.rohit.movielist.datasource.model.Result;
import com.rohit.movielist.datasource.repository.DataSource;
import com.rohit.movielist.detail.MovieDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.progressBarHome)
    ProgressBar progressBarHome;

    @BindView(R.id.recyclerViewMovieList)
    RecyclerView recyclerViewMovieList;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private Context mContext;
    private HomeAdapter mHomeAdapter;
    private Snackbar mSnackbar;

    public static HomeFragment newInstance(Context context) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.mContext = context;
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        mHomeAdapter = new HomeAdapter(mPresenter);
        recyclerViewMovieList.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerViewMovieList.setAdapter(mHomeAdapter);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this, new DataSource(), mContext);
    }

    @Override
    public void updateProgressBar(int visibility) {
        progressBarHome.setVisibility(visibility);
    }

    @Override
    public void showSnackBarMessage(String message, boolean hasRetry) {
        if (mSnackbar != null && mSnackbar.isShown()) {
            mSnackbar.dismiss();
        }
        int snackBarLength = hasRetry ? Snackbar.LENGTH_INDEFINITE : Snackbar.LENGTH_SHORT;
        mSnackbar = Snackbar.make(coordinatorLayout, message, snackBarLength);
        if (hasRetry) {
            mSnackbar.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSnackbar.dismiss();
                    mPresenter.onSnackbarRetry();
                }
            });
        }
        mSnackbar.show();
    }

    @Override
    public void showResult(List<Result> moviesLists) {
        mHomeAdapter.addMovies(moviesLists);
    }

    @Override
    public void openDetailPage(int movieId, String movieName) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, MovieDetailFragment.newInstance(movieId, mContext, movieName)).addToBackStack("").commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
