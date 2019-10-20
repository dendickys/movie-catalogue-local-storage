package com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.adapter;

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
import com.dendickys.moviecataloguelocalstorage.ui.favorites.tvshow.entity.FavTvShow;

import java.util.List;

import static com.dendickys.moviecataloguelocalstorage.interfaces.RetrofitApi.BASE_URL_POSTER;

public class FavTvShowAdapter extends RecyclerView.Adapter<FavTvShowAdapter.FavTvShowViewHolder> {

    private List<FavTvShow> favTvShows;
    private Context mContext;

    public FavTvShowAdapter(List<FavTvShow> favTvShows, Context context) {
        this.favTvShows = favTvShows;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FavTvShowAdapter.FavTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new FavTvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavTvShowAdapter.FavTvShowViewHolder holder, int position) {
        holder.bind(favTvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return favTvShows.size();
    }

    class FavTvShowViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterTvShow;
        private TextView titleTvShow, releaseDateTvShow, overviewTvShow;

        FavTvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            posterTvShow = itemView.findViewById(R.id.img_poster_tvshow);
            titleTvShow = itemView.findViewById(R.id.tv_title_tvshow);
            releaseDateTvShow = itemView.findViewById(R.id.tv_release_date_tvshow);
            overviewTvShow = itemView.findViewById(R.id.tv_overview_tvshow);
        }

        void bind(FavTvShow favTvShow) {
            Glide.with(itemView.getContext())
                    .load(BASE_URL_POSTER + "w185/" + favTvShow.getPoster_path())
                    .apply(new RequestOptions()).override(100, 150)
                    .into(posterTvShow);
            titleTvShow.setText(favTvShow.getTitle());
            releaseDateTvShow.setText(favTvShow.getRelease_date());
            overviewTvShow.setText(favTvShow.getOverview());
        }
    }
}
