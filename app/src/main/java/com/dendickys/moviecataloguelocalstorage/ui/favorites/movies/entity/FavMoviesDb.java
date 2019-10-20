package com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FavMovies.class}, version = 1)
public abstract class FavMoviesDb extends RoomDatabase {

    public abstract FavMoviesDao favMoviesDao();
}
