package abika.sinaudicodingjavaexpert.submissionmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TvShow;
import abika.sinaudicodingjavaexpert.submissionmovie.ui.DetailActivity;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.CategoryViewHolder> {
    private final Context context;
    private ArrayList<Movie> listMovie;

    public TvshowAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListTvshow(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.txtTvshowName.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieName());
        categoryViewHolder.txtTvshowDescription.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieDescription());
//        categoryViewHolder.txtMovieRelease.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRelease());
        categoryViewHolder.txtTvshowGenre.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieGenre());
        categoryViewHolder.txtTvshowRating.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());

        categoryViewHolder.getAdapterPosition();
        Glide.with(context)
                .load(getListMovie().get(categoryViewHolder.getAdapterPosition()).getImgResource())
                .apply(new RequestOptions())
                .into(categoryViewHolder.imgTvshowPoster);


        float backgroundRating = Float.parseFloat(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());

        if (backgroundRating >= 8.0) {
            categoryViewHolder.txtTvshowRating.setBackgroundColor(Color.parseColor("#3498db"));
        } else if (backgroundRating >= 7.0) {
            categoryViewHolder.txtTvshowRating.setBackgroundColor(Color.parseColor("#2ecc71"));
        } else if (backgroundRating >= 6.0) {
            categoryViewHolder.txtTvshowRating.setBackgroundColor(Color.parseColor("#f1c40f"));
        } else if (backgroundRating >= 5.0) {
            categoryViewHolder.txtTvshowRating.setBackgroundColor(Color.parseColor("#e67e22"));
        } else {
            categoryViewHolder.txtTvshowRating.setBackgroundColor(Color.parseColor("#e74c3c"));
        }

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Kamu Memilih "+  getListTvshow().get(position).getTvshowName(), Toast.LENGTH_SHORT).show();

                Movie tvshow = new Movie();
                tvshow.setMovieName(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieName());
                tvshow.setMovieRating(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());
                tvshow.setMovieGenre(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieGenre());
                tvshow.setMovieDescription(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieDescription());
                tvshow.setMovieRelease(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRelease());
                tvshow.setImgResource(getListMovie().get(categoryViewHolder.getAdapterPosition()).getImgResource());

                Intent moveIntent = new Intent(context, DetailActivity.class);
                moveIntent.putExtra(DetailActivity.EXTRA_TVSHOW, tvshow);
                context.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        final TextView txtTvshowName;
        final TextView txtTvshowDescription;
        final TextView txtTvshowGenre;
        final TextView txtTvshowRating;
        final ImageView imgTvshowPoster;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTvshowName = itemView.findViewById(R.id.tv_item_name);
            txtTvshowDescription = itemView.findViewById(R.id.tv_item_desc);
            txtTvshowGenre = itemView.findViewById(R.id.tv_item_genre);
            txtTvshowRating = itemView.findViewById(R.id.tv_item_rating);
            imgTvshowPoster = itemView.findViewById(R.id.iv_item_photo);
        }
    }
}