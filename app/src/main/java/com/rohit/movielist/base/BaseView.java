package com.rohit.movielist.base;

public interface BaseView {

    void updateProgressBar(int visibility);

    void showSnackBarMessage(String message, boolean hasRetry);

}
