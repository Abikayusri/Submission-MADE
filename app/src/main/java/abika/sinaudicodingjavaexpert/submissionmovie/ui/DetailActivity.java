package abika.sinaudicodingjavaexpert.submissionmovie.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TvShow;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle();

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView tvMovieName = findViewById(R.id.tv_detail_name);
        TextView tvMovieRate = findViewById(R.id.tv_detail_rate);
        TextView tvMovieGenre = findViewById(R.id.tv_detail_genre);
        TextView tvMovieRelease = findViewById(R.id.tv_detail_release);
        TextView tvMovieDesc = findViewById(R.id.tv_detail_desc);
        ImageView imgMoviePoster = findViewById(R.id.iv_detail_poster);

        final Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        final TvShow tvshow = getIntent().getParcelableExtra(EXTRA_TVSHOW);


        tvMovieName.setText(movie.getMovieName());
        tvMovieRate.setText(movie.getMovieRating());
        tvMovieGenre.setText(movie.getMovieGenre());
        tvMovieRelease.setText(movie.getMovieRelease());
        tvMovieDesc.setText(movie.getMovieDescription());
        Glide.with(this).load(movie.getImgResource()).into(imgMoviePoster);

//        float ratingMovie = Float.parseFloat(movie.getMovieRating());
//
//        if (ratingMovie>=8.0){
//            tvMovieRate.setTextColor(Color.parseColor("#3498db"));
//        } else if (ratingMovie>=7.0){
//            tvMovieRate.setTextColor(Color.parseColor("#2ecc71"));
//        } else if (ratingMovie>=6.0){
//            tvMovieRate.setTextColor(Color.parseColor("#f1c40f"));
//        } else if (ratingMovie>=5.0){
//            tvMovieRate.setTextColor(Color.parseColor("#e67e22"));
//        } else {
//            tvMovieRate.setTextColor(Color.parseColor("#e74c3c"));
//        }
    }

    private void setActionBarTitle(){
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail Movie");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}