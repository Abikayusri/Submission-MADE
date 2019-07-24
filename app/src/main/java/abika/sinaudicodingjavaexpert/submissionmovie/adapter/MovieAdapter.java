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
import abika.sinaudicodingjavaexpert.submissionmovie.ui.DetailActivity;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {

    private final Context context;
    private ArrayList<Movie> listMovie;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
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
        categoryViewHolder.txtMovieName.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieName());
        categoryViewHolder.txtMovieDescription.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieDescription());
//        categoryViewHolder.txtMovieRelease.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRelease());
        categoryViewHolder.txtMovieGenre.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieGenre());
        categoryViewHolder.txtMovieRating.setText(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());

        categoryViewHolder.getAdapterPosition();
        Glide.with(context)
                .load(getListMovie().get(categoryViewHolder.getAdapterPosition()).getImgResource())
                .apply(new RequestOptions())
                .into(categoryViewHolder.imgMoviePoster);


        float backgroundRating = Float.parseFloat(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());

        if (backgroundRating >= 8.0) {
            categoryViewHolder.txtMovieRating.setBackgroundColor(Color.parseColor("#3498db"));
        } else if (backgroundRating >= 7.0) {
            categoryViewHolder.txtMovieRating.setBackgroundColor(Color.parseColor("#2ecc71"));
        } else if (backgroundRating >= 6.0) {
            categoryViewHolder.txtMovieRating.setBackgroundColor(Color.parseColor("#f1c40f"));
        } else if (backgroundRating >= 5.0) {
            categoryViewHolder.txtMovieRating.setBackgroundColor(Color.parseColor("#e67e22"));
        } else {
            categoryViewHolder.txtMovieRating.setBackgroundColor(Color.parseColor("#e74c3c"));
        }

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Kamu Memilih "+  getListMovie().get(position).getMovieName(), Toast.LENGTH_SHORT).show();

                Movie movie = new Movie();
                movie.setMovieName(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieName());
                movie.setMovieRating(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRating());
                movie.setMovieGenre(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieGenre());
                movie.setMovieDescription(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieDescription());
                movie.setMovieRelease(getListMovie().get(categoryViewHolder.getAdapterPosition()).getMovieRelease());
                movie.setImgResource(getListMovie().get(categoryViewHolder.getAdapterPosition()).getImgResource());

                Intent moveIntent = new Intent(context, DetailActivity.class);
                moveIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                context.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        final TextView txtMovieName;
        final TextView txtMovieDescription;
        final TextView txtMovieGenre;
        final TextView txtMovieRating;
        final ImageView imgMoviePoster;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMovieName = itemView.findViewById(R.id.tv_item_name);
            txtMovieDescription = itemView.findViewById(R.id.tv_item_desc);
            txtMovieGenre = itemView.findViewById(R.id.tv_item_genre);
            txtMovieRating = itemView.findViewById(R.id.tv_item_rating);
            imgMoviePoster = itemView.findViewById(R.id.iv_item_photo);
        }
    }
}