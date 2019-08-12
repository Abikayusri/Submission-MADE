package abika.sinaudicodingjavaexpert.submissionmovie.ui.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.R;

public class MoviesDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private ImageView mvPoster;
    private TextView mvTitle, mvRate, mvGenre, mvRelease, mvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setActionBarTitle();

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mvTitle = findViewById(R.id.tv_detail_name);
        mvRate = findViewById(R.id.tv_detail_rate);
//        mvGenre= findViewById(R.id.tv_detail_genre);
        mvRelease= findViewById(R.id.tv_detail_release);
        mvOverview= findViewById(R.id.tv_detail_desc);
        mvPoster= findViewById(R.id.iv_detail_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);
        if (movie != null) {
            showData(movie);
        }
    }

    private void showData(Movie movie) {
        Glide.with(this).load(BuildConfig.URL_POSTER +movie.getMoviePoster()).into(mvPoster);
        mvTitle.setText(movie.getMovieTitle());
        mvRelease.setText(movie.getMovieRelease());
        mvRate.setText(String.valueOf(movie.getMovieRating()));
        mvOverview.setText(movie.getMovieOverview());
    }

    private void setActionBarTitle(){
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail Movie");
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}