package com.dendickys.moviecataloguelocalstorage.ui.tvshow.adapter;

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
import com.dendickys.moviecataloguelocalstorage.ui.tvshow.DetailTvShowActivity;
import com.dendickys.moviecataloguelocalstorage.ui.tvshow.model.TvShow;

import java.util.ArrayList;

import static com.dendickys.moviecataloguelocalstorage.interfaces.RetrofitApi.BASE_URL_POSTER;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private ArrayList<TvShow> listTvShow;

    public TvShowAdapter(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.bind(listTvShow.get(position));
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterTvShow;
        private TextView titleTvShow, releaseDateTvShow, overviewTvShow;

        TvShowViewHolder(@NonNull final View itemView) {
            super(itemView);

            posterTvShow = itemView.findViewById(R.id.img_poster_tvshow);
            titleTvShow = itemView.findViewById(R.id.tv_title_tvshow);
            releaseDateTvShow = itemView.findViewById(R.id.tv_release_date_tvshow);
            overviewTvShow = itemView.findViewById(R.id.tv_overview_tvshow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
                    intent.putExtra(DetailTvShowActivity.TV_SHOW_ID, listTvShow.get(position));
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        void bind(TvShow tvShow) {
            Glide.with(itemView.getContext())
                    .load(BASE_URL_POSTER + "w185/" + tvShow.getPoster_path())
                    .apply(new RequestOptions()).override(100, 150)
                    .into(posterTvShow);
            titleTvShow.setText(tvShow.getTitle());
            releaseDateTvShow.setText(tvShow.getRelease_date());
            overviewTvShow.setText(tvShow.getOverview());
        }
    }
}