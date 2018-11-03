package com.rohit.movielist.constant;

public class Constants {

    public static class UrlConstant {
        public static final String BASE_URL = "https://api.themoviedb.org";
        public static final String API_KEY = "cd98a3434dbd8fb795c1d754289b63c4";
        public static final String MOVIE_LIST_URL = "/3/discover/movie?sort_by=popularity.desc&api_key=" + API_KEY;
        public static final String MOVIE_DETAIL_URL = "3/movie/{movieId}?api_key=" + API_KEY + "&language=en-US";
        public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
    }

    public static class BundleId {
        public static final String MOVIE_ID = "MOVIE_ID";
        public static final String MOVIE_NAME = "MOVIE_NAME";
    }
}
