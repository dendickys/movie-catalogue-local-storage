package com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FavTvShow.class}, version = 1)
public abstract class FavTvShowDb extends RoomDatabase {
    public abstract FavTvShowDao favTvShowDao();
}
