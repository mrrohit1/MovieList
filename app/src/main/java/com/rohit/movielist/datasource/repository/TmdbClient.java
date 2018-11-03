package com.rohit.movielist.datasource.repository;

import com.rohit.movielist.constant.Constants;
import com.rohit.movielist.datasource.model.MovieDetail;
import com.rohit.movielist.datasource.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdbClient {

    @GET(Constants.UrlConstant.MOVIE_LIST_URL)
    Call<MoviesList> getMovieList();

    @GET(Constants.UrlConstant.MOVIE_DETAIL_URL)
    Call<MovieDetail> getMovieDetail(@Path("movieId") int id);

}
