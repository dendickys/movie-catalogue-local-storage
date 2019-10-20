package com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavMoviesDao {
    @Insert
    public void addFavMovies(FavMovies favMovies);

    @Query("SELECT * FROM movies_favorites")
    List<FavMovies> getAllFavMovies();

    @Query("SELECT EXISTS (SELECT 1 FROM movies_favorites WHERE id=:id)")
    public int isFavorite(int id);

    @Delete
    public void deleteFavMovies(FavMovies favMovies);
}
