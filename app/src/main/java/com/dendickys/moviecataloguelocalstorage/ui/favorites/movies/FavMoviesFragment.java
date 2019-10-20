package com.dendickys.moviecataloguelocalstorage.ui.favorites.movies;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dendickys.moviecataloguelocalstorage.R;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.entity.FavMovies;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.adapter.FavMoviesAdapter;

import java.util.List;

import static com.dendickys.moviecataloguelocalstorage.MainActivity.favMoviesDb;

public class FavMoviesFragment extends Fragment {

    private RecyclerView recyclerView;

    public FavMoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onBind(view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getFavMovies();
    }

    private void onBind(View view) {
        recyclerView = view.findViewById(R.id.rv_movies_favorites);
    }

    private void getFavMovies() {
        List<FavMovies> favMovies = favMoviesDb.favMoviesDao().getAllFavMovies();
        FavMoviesAdapter favMoviesAdapter = new FavMoviesAdapter(favMovies, getContext());
        recyclerView.setAdapter(favMoviesAdapter);
    }
}
