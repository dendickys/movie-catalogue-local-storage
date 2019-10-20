package com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavTvShowDao {
    @Insert
    public void addFavTvShow(FavTvShow favTvShow);

    @Query("SELECT * FROM tvshow_favorites")
    List<FavTvShow> getAllFavTvShow();

    @Query("SELECT EXISTS (SELECT 1 FROM tvshow_favorites WHERE id=:id)")
    public int isFavorite(int id);

    @Delete
    public void deleteFavTvShow(FavTvShow favTvShow);
}
