package com.rohit.movielist.detail;

import com.rohit.movielist.base.BasePresenter;
import com.rohit.movielist.base.BaseView;
import com.rohit.movielist.datasource.model.MovieDetail;

public interface MovieDetailContract {

    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView{

        void setMovieDetails(MovieDetail movieDetails);

    }
}
