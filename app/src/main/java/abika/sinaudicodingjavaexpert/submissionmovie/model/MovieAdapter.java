package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.R;

public class MovieAdapter extends BaseAdapter {

    Context context;
    ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> ourMovies){
        this.context = context;
        this.movies = ourMovies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view==null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_movie, null);

            holder.moviePoster = view.findViewById(R.id.iv_item_photo);
            holder.movieTitle = view.findViewById(R.id.tv_item_name);
            holder.movieGenre = view.findViewById(R.id.tv_item_genre);
            holder.movieRating = view.findViewById(R.id.tv_item_rating);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.moviePoster.setImageResource(movies.get(i).getImgResource());
        holder.moviePoster.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.movieTitle.setText(movies.get(i).getMovieName());
        holder.movieGenre.setText(movies.get(i).getMovieGenre());
        holder.movieRating.setText( "Rate: " + String.valueOf(movies.get(i).getMovieRating()));

        return view;
    }

    static class ViewHolder {
        ImageView moviePoster;
        TextView movieTitle;
        TextView movieRating;
        TextView movieGenre;
    }
}
