package com.dendickys.moviecataloguelocalstorage.ui.tvshow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ObjectTvShow {
    @SerializedName("results")
    private ArrayList<TvShow> listTvShow;

    public ArrayList<TvShow> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }
}
