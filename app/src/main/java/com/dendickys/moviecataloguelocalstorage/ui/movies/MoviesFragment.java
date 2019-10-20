package com.dendickys.moviecataloguelocalstorage.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dendickys.moviecataloguelocalstorage.R;
import com.dendickys.moviecataloguelocalstorage.ui.movies.adapter.MoviesAdapter;
import com.dendickys.moviecataloguelocalstorage.ui.movies.model.Movies;
import com.dendickys.moviecataloguelocalstorage.ui.movies.viewmodels.MoviesViewModel;

import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private ProgressBar progressBar;

    public MoviesFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindData(view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MoviesViewModel moviesViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MoviesViewModel.class);
        showLoading(true);

        moviesViewModel.getAllMovies().observe(this, new Observer<ArrayList<Movies>>() {
            @Override
            public void onChanged(ArrayList<Movies> movies) {
                if (movies != null) {
                    moviesAdapter = new MoviesAdapter(movies);
                    moviesAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(moviesAdapter);
                    showLoading(false);
                }
            }
        });
    }

    private void bindData(View view) {
        progressBar = view.findViewById(R.id.progressBar_movies);
        recyclerView = view.findViewById(R.id.rv_movies);
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}