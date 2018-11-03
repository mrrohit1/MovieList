package com.rohit.movielist.datasource.repository;

import com.rohit.movielist.datasource.model.MovieDetail;
import com.rohit.movielist.datasource.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdbClient {

    @GET("/3/discover/movie?sort_by=popularity.desc&api_key=cd98a3434dbd8fb795c1d754289b63c4")
    Call<MoviesList> getMovieList();

    @GET("3/movie/{movieId}?api_key=cd98a3434dbd8fb795c1d754289b63c4&language=en-US")
    Call<MovieDetail> getMovieDetail(@Path("movieId") int id);

}
