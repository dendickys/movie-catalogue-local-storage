package com.dendickys.moviecataloguelocalstorage.ui.favorites;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dendickys.moviecataloguelocalstorage.R;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.FavMoviesFragment;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.FavTvShowFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_favorites_movies, R.string.tab_favorites_tv_show};
    private final Context mContext;

    public SectionPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavMoviesFragment();
            case 1:
                return new FavTvShowFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
}
