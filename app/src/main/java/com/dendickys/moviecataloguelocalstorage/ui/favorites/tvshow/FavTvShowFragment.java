package com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow;


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
import com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.adapter.FavTvShowAdapter;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.entity.FavTvShow;

import java.util.List;

import static com.dendickys.moviecataloguelocalstorage.MainActivity.favTvShowDb;

public class FavTvShowFragment extends Fragment {

    private RecyclerView recyclerView;

    public FavTvShowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onBind(view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getFavTvShow();
    }

    private void onBind(View view) {
        recyclerView = view.findViewById(R.id.rv_tvshow_favorites);
    }

    private void getFavTvShow() {
        List<FavTvShow> favTvShows = favTvShowDb.favTvShowDao().getAllFavTvShow();
        FavTvShowAdapter favTvShowAdapter = new FavTvShowAdapter(favTvShows, getContext());
        recyclerView.setAdapter(favTvShowAdapter);
    }
}
