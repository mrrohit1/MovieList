package com.rohit.movielist.datasource.repository;


import com.rohit.movielist.datasource.model.MoviesList;

import retrofit2.Call;

public interface DataSourceContract {

    Call<MoviesList> onFetchresult();
}
