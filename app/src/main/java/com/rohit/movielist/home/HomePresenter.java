package com.rohit.movielist.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.rohit.movielist.datasource.model.MoviesList;
import com.rohit.movielist.datasource.model.Result;
import com.rohit.movielist.datasource.repository.DataSourceContract;
import com.rohit.movielist.utils.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private DataSourceContract mDataSourceContract;
    private Context mContext;

    public HomePresenter(HomeContract.View view, DataSourceContract dataSourceContract, Context context) {
        this.mView = view;
        this.mDataSourceContract = dataSourceContract;
        this.mContext = context;
    }

    @Override
    public void onSnackbarRetry() {

    }

    @Override
    public void onStart() {
        fetchMovieList();
        mView.updateProgressBar(View.VISIBLE);
    }

    private void fetchMovieList() {
        mDataSourceContract.onFetchresult().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(@NonNull Call<MoviesList> call, @NonNull Response<MoviesList> response) {
                if (response.body() != null) {
                    List<Result> results = response.body().getResults();
                    mView.showResult(results);
                }
                mView.updateProgressBar(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<MoviesList> call, @NonNull Throwable t) {
                if (!NetworkUtils.isInternetAvaialble(mContext)) {
                    mView.showSnackBarMessage("Internet not available", true);
                } else {
                    mView.showSnackBarMessage("Network Error! Please try again", true);
                }
                mView.updateProgressBar(View.GONE);
            }
        });
    }
}
