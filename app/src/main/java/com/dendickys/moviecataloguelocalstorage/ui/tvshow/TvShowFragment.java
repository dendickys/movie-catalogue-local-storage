package com.dendickys.moviecataloguelocalstorage.ui.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dendickys.moviecataloguelocalstorage.R;

public class TvShowFragment extends Fragment {

    private TvShowViewModel tvShowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tvShowViewModel =
                ViewModelProviders.of(this).get(TvShowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tv_show, container, false);
        final TextView textView = root.findViewById(R.id.text_tv_show);
        tvShowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}