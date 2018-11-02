package com.rohit.movielist.datasource.repository;

import com.rohit.movielist.datasource.model.MoviesList;
import com.rohit.movielist.dependencies.DaggerNetworkComponent;

import javax.inject.Inject;

import retrofit2.Call;

public class DataSource implements DataSourceContract {

    @Inject
    TmdbClient tmdbClient;

    public DataSource() {
        DaggerNetworkComponent.builder().build().inject(this);
    }

    @Override
    public Call<MoviesList> onFetchresult() {
        return tmdbClient.getMovieList();
    }
}
