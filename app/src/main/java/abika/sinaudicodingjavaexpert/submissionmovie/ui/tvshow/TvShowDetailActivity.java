package abika.sinaudicodingjavaexpert.submissionmovie.ui.tvshow;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TVShow;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private ImageView mvPoster;
    private TextView mvTitle, mvRate, mvGenre, mvRelease, mvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setActionBarTitle();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mvTitle = findViewById(R.id.tv_detail_name);
        mvRate = findViewById(R.id.tv_detail_rate);
//        mvGenre= findViewById(R.id.tv_detail_genre);
        mvRelease = findViewById(R.id.tv_detail_release);
        mvOverview = findViewById(R.id.tv_detail_desc);
        mvPoster = findViewById(R.id.iv_detail_poster);

        TVShow tvshow = getIntent().getParcelableExtra(EXTRA_DATA);
        if (tvshow != null) {
            showData(tvshow);
        }
    }

    private void showData(TVShow tvshow) {
        Glide.with(this).load(BuildConfig.URL_POSTER + tvshow.getTVShowPoster()).into(mvPoster);
        mvTitle.setText(tvshow.getTVShowName());
        Log.d("MoviesDetail", "Status Data: " + tvshow.getTVShowName());

        String releaseDate = tvshow.getTVShowRelease();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = parser.parse(releaseDate);
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy", Locale.getDefault());
            String formatedDate = formatter.format(date);

            mvRelease.setText(formatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mvRate.setText(String.valueOf(tvshow.getTVShowRating()));
        mvOverview.setText(tvshow.getTVShowOverview());
    }

    private void setActionBarTitle() {
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail TVShow");
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