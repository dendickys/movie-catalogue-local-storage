package com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dendickys.moviecataloguelocalstorage.R;
import com.dendickys.moviecataloguelocalstorage.ui.favorites.movies.entity.FavMovies;

import java.util.List;

import static com.dendickys.moviecataloguelocalstorage.interfaces.RetrofitApi.BASE_URL_POSTER;

public class FavMoviesAdapter extends RecyclerView.Adapter<FavMoviesAdapter.FavMoviesViewHolder> {

    private List<FavMovies> favMovies;
    private Context mContext;

    public FavMoviesAdapter(List<FavMovies> favMovies, Context context) {
        this.favMovies = favMovies;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FavMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new FavMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavMoviesViewHolder holder, int position) {
        holder.bind(favMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return favMovies.size();
    }

    class FavMoviesViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterMovie;
        private TextView titleMovie, releaseDateMovie, overviewMovie;

        FavMoviesViewHolder(@NonNull final View itemView) {
            super(itemView);

            posterMovie = itemView.findViewById(R.id.img_poster_movie);
            titleMovie = itemView.findViewById(R.id.tv_title_movie);
            releaseDateMovie = itemView.findViewById(R.id.tv_release_date_movie);
            overviewMovie = itemView.findViewById(R.id.tv_overview_movie);
        }

        void bind(FavMovies favMovies) {
            Glide.with(itemView.getContext())
                    .load(BASE_URL_POSTER + "w185/" + favMovies.getPoster_path())
                    .apply(new RequestOptions()).override(100, 150)
                    .into(posterMovie);
            titleMovie.setText(favMovies.getTitle());
            releaseDateMovie.setText(favMovies.getRelease_date());
            overviewMovie.setText(favMovies.getOverview());
        }
    }
}
