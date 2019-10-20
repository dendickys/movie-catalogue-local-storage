package com.dendickys.moviecataloguelocalstorage.interfaces;

import com.dendickys.moviecataloguelocalstorage.BuildConfig;
import com.dendickys.moviecataloguelocalstorage.ui.movies.model.ObjectMovies;
import com.dendickys.moviecataloguelocalstorage.ui.tvshow.model.ObjectTvShow;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    String BASE_URL = "https://api.themoviedb.org/3/";
    String BASE_URL_POSTER = "https://image.tmdb.org/t/p/";
    String API_KEY = BuildConfig.TMDB_API_KEY;

    @GET("discover/movie?api_key=" + API_KEY + "&language=en-US")
    Call<ObjectMovies> getAllMovies();

    @GET("discover/tv?api_key=" + API_KEY + "&language=en-US")
    Call<ObjectTvShow> getAllTvShow();
}
