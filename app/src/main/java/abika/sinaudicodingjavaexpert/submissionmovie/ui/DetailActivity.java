package abika.sinaudicodingjavaexpert.submissionmovie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //mengambil data Movie yang dikirimkan oleh MainActivity dengan identitas EXTRA_MOVIE
        Movie selectedMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if(selectedMovie!=null) {
            ImageView imgFoto = findViewById(R.id.iv_detail_photo);
            Picasso.get().load(selectedMovie.getImgResource()).fit().centerCrop().into(imgFoto);

            TextView txtNama = findViewById(R.id.tv_detail_name);
            txtNama.setText(selectedMovie.getMovieName());

            TextView txtDesc = findViewById(R.id.tv_detail_description);
            txtDesc.setText(selectedMovie.getMovieDescription());

            TextView txtRilis = findViewById(R.id.tv_detail_release);
            txtRilis.setText("(" + selectedMovie.getMovieRelease() + ")");

            TextView txtGenre = findViewById(R.id.tv_detail_genre);
            txtGenre.setText(selectedMovie.getMovieGenre());

            TextView txtRate = findViewById(R.id.tv_detail_rating);
            txtRate.setText("Rating: " + String.valueOf(selectedMovie.getMovieRating()) + "/10");
        }
        setActionBarTitle("MOVIE CATALOGUE");
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
