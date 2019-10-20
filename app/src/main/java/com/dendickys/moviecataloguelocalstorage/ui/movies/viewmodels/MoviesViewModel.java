package com.dendickys.moviecataloguelocalstorage.ui.movies.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dendickys.moviecataloguelocalstorage.interfaces.RetrofitApi;
import com.dendickys.moviecataloguelocalstorage.ui.movies.model.Movies;
import com.dendickys.moviecataloguelocalstorage.ui.movies.model.ObjectMovies;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Movies>> moviesList;

    public LiveData<ArrayList<Movies>> getAllMovies() {
        if (moviesList == null) {
            moviesList = new MutableLiveData<ArrayList<Movies>>();
            loadMovies();
        }
        return moviesList;
    }

    private void loadMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);
        Call<ObjectMovies> call = api.getAllMovies();

        call.enqueue(new Callback<ObjectMovies>() {
            @Override
            public void onResponse(Call<ObjectMovies> call, Response<ObjectMovies> response) {
                assert response.body() != null;
                moviesList.setValue(response.body().getListMovies());
            }

            @Override
            public void onFailure(Call<ObjectMovies> call, Throwable t) {
                Log.d("onFailure: ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}