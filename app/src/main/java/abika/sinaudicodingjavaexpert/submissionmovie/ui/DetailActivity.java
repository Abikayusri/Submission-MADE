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
import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    private ScrollView bgMovieDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //final String title1 = "Detail Movie";
        setActionBarTitle();

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView tvMovieName = findViewById(R.id.txt_movie_name);
        TextView tvMovieRate = findViewById(R.id.txt_movie_rate);
        TextView tvMovieCat = findViewById(R.id.txt_movie_cat);
        TextView tvMovieDesc = findViewById(R.id.txt_movie_desc);
        ImageView imgMoviePoster = findViewById(R.id.img_poster_movie);
        bgMovieDetail = findViewById(R.id.bg_movie_detail);

        final Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvMovieName.setText(movie.getMovieName());
        tvMovieRate.setText(movie.getMovieRating());
        tvMovieCat.setText(movie.getMovieGenre());
        tvMovieDesc.setText(movie.getMovieDescription());

        Glide.with(this).load(movie.getImgResource()).into(imgMoviePoster);

        //noinspection deprecation
        Glide.with(this).load(movie.getImgResource())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(15, 3)))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, Transition<? super Drawable> transition) {
                        bgMovieDetail.setBackground(resource);
                    }
                });

        float backgroundRating = Float.parseFloat(movie.getMovieRating());

        if (backgroundRating>=8.0){
            tvMovieRate.setTextColor(Color.parseColor("#3498db"));
        } else if (backgroundRating>=7.0){
            tvMovieRate.setTextColor(Color.parseColor("#2ecc71"));
        } else if (backgroundRating>=6.0){
            tvMovieRate.setTextColor(Color.parseColor("#f1c40f"));
        } else if (backgroundRating>=5.0){
            tvMovieRate.setTextColor(Color.parseColor("#e67e22"));
        } else {
            tvMovieRate.setTextColor(Color.parseColor("#e74c3c"));
        }



    }

    private void setActionBarTitle(){
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail Movie");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}