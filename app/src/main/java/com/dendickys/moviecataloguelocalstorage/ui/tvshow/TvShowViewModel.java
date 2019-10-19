package com.dendickys.moviecataloguelocalstorage.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TvShowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TvShowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tv show fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}