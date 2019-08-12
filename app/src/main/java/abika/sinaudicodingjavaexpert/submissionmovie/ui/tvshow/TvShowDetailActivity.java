package abika.sinaudicodingjavaexpert.submissionmovie.ui.tvshow;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TVShow;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private ImageView tvPoster;
    private TextView tvTitle, tvRate, tvGenre, tvRelease, tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);
        setActionBarTitle();

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvTitle = findViewById(R.id.tv_detail_name);
        tvRate = findViewById(R.id.tv_detail_rate);
//        tvGenre= findViewById(R.id.tv_detail_genre);
        tvRelease= findViewById(R.id.tv_detail_release);
        tvOverview= findViewById(R.id.tv_detail_desc);
        tvPoster= findViewById(R.id.iv_detail_poster);

        TVShow tvshow = getIntent().getParcelableExtra(EXTRA_DATA);
        if (tvshow != null) {
            showData(tvshow);
        }
    }

    private void showData(TVShow tvshow) {
        Glide.with(this).load(BuildConfig.URL_POSTER +tvshow.getTVShowPoster()).into(tvPoster);
        tvTitle.setText(tvshow.getTVShowName());
        tvRelease.setText(tvshow.getTVShowRelease());
        tvRate.setText(String.valueOf(tvshow.getTVShowRating()));
        tvOverview.setText(tvshow.getTVShowOverview());
    }

    private void setActionBarTitle(){
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