package abika.sinaudicodingjavaexpert.submissionmovie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.data.MovieResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Context context;

    private ArrayList<Movie> movieList = new ArrayList<>();
    public MovieAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Movie> getMovieList() { return movieList; }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }


    public void setData(MovieResponse items) {
        movieList.clear();
        movieList.addAll(items.getMoviesList());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new MovieViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int position) {
        movieViewHolder.txtMovieTitle.setText(movieList.get(position).getMovieOrTitle());
        movieViewHolder.txtMovieDescription.setText(movieList.get(position).getMovieOverview());
        movieViewHolder.txtMovieRating.setText(String.valueOf(movieList.get(position).getMovieRating()));
        movieViewHolder.getAdapterPosition();

        Log.d("MovieAdapter", "Status Data: " + movieList.get(position).getMovieTitle());
        Log.d("MovieAdapter", "Status Data: " + movieList.get(position).getMovieOrTitle());
        Log.d("MovieAdapter", "Status Data: " + movieList.get(position).getMovieOverview());
        Log.d("MovieAdapter", "Status Data: " + movieList.get(position).getMovieRating());

        Glide.with(context)
                .load(BuildConfig.URL_POSTER + getMovieList()
                        .get(position)
                        .getMoviePoster())
                .into(movieViewHolder.imgMoviePoster);
    }

    @Override
    public int getItemCount() { return getMovieList().size(); }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView txtMovieTitle;
        final TextView txtMovieDescription;
        final TextView txtMovieGenre;
        final TextView txtMovieRating;
        final ImageView imgMoviePoster;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMovieTitle = itemView.findViewById(R.id.tv_item_name);
            txtMovieDescription = itemView.findViewById(R.id.tv_item_desc);
            txtMovieGenre = itemView.findViewById(R.id.tv_item_genre);
            txtMovieRating = itemView.findViewById(R.id.tv_item_rating);
            imgMoviePoster = itemView.findViewById(R.id.iv_item_photo);
        }
    }
}