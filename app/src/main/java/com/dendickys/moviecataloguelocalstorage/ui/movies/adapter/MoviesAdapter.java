package com.dendickys.moviecataloguelocalstorage.ui.movies.adapter;

import android.content.Intent;
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
import com.dendickys.moviecataloguelocalstorage.ui.movies.DetailMoviesActivity;
import com.dendickys.moviecataloguelocalstorage.ui.movies.model.Movies;

import java.util.ArrayList;

import static com.dendickys.moviecataloguelocalstorage.interfaces.RetrofitApi.BASE_URL_POSTER;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private ArrayList<Movies> listMovies;

    public MoviesAdapter(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.bind(listMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterMovie;
        private TextView titleMovie, releaseDataMovie, overviewMovie;

        MoviesViewHolder(@NonNull final View itemView) {
            super(itemView);

            posterMovie = itemView.findViewById(R.id.img_poster_movie);
            titleMovie = itemView.findViewById(R.id.tv_title_movie);
            releaseDataMovie = itemView.findViewById(R.id.tv_release_date_movie);
            overviewMovie = itemView.findViewById(R.id.tv_overview_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(itemView.getContext(), DetailMoviesActivity.class);
                    intent.putExtra(DetailMoviesActivity.MOVIE_ID, listMovies.get(position));
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        void bind(Movies movieItems) {
            Glide.with(itemView.getContext())
                    .load(BASE_URL_POSTER + "w185/" + movieItems.getPoster_path())
                    .apply(new RequestOptions()).override(100, 150)
                    .into(posterMovie);
            titleMovie.setText(movieItems.getTitle());
            releaseDataMovie.setText(movieItems.getRelease_date());
            overviewMovie.setText(movieItems.getOverview());
        }
    }
}
