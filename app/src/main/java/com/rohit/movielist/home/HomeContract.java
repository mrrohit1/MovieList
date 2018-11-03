package com.rohit.movielist.home;

import com.rohit.movielist.base.BasePresenter;
import com.rohit.movielist.base.BaseView;
import com.rohit.movielist.datasource.model.MoviesList;
import com.rohit.movielist.datasource.model.Result;

import java.util.List;

public interface HomeContract {

    interface Presenter extends BasePresenter {

        void onItemClick(int movieId,String movieName);

    }

    interface View extends BaseView {

        void showResult(List<Result> moviesLists);

        void openDetailPage(int movieId,String movieName);

    }

}
