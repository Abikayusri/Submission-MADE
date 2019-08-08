package abika.sinaudicodingjavaexpert.submissionmovie.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle();

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

        tvMovieName.setText(movie.getMovieName());
        tvMovieRate.setText(movie.getMovieRating());
        tvMovieGenre.setText(movie.getMovieGenre());
        tvMovieRelease.setText(movie.getMovieRelease());
        tvMovieDesc.setText(movie.getMovieDescription());
        Glide.with(this).load(movie.getImgResource()).into(imgMoviePoster);
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