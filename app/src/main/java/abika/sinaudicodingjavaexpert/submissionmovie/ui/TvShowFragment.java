package abika.sinaudicodingjavaexpert.submissionmovie.ui;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.MovieAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.TvshowAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TvShow;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    private String[] dataTvName;
    private String[] dataTvDescription;
    private String[] dataTvRelease;
    private String[] dataTvRate;
    private String[] dataTvGenre;
    private TypedArray dataTvPoster;

    private RecyclerView rvCategory;
    private final ArrayList<Movie> list = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tvshow, container, false);
        rvCategory = v.findViewById(R.id.lv_list_tv);
        rvCategory.setHasFixedSize(true);

        prepare();
        addItem();

        showRecycleList();

        return v;
    }


    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < dataTvName.length; i++) {
            Movie movie = new Movie();
            movie.setImgResource(dataTvPoster.getResourceId(i, -1));
            movie.setMovieName(dataTvName[i]);
            movie.setMovieDescription(dataTvDescription[i]);
            movie.setMovieRelease(dataTvRelease[i]);
            movie.setMovieRating(dataTvRate[i]);
            movie.setMovieGenre(dataTvGenre[i]);

            movies.add(movie);
        }
        list.addAll(movies);
    }

    private void prepare() {
        dataTvName = getResources().getStringArray(R.array.data_tv_name);
        dataTvRate = getResources().getStringArray(R.array.data_tv_rating);
        dataTvGenre = getResources().getStringArray(R.array.data_tv_genre);
        dataTvRelease = getResources().getStringArray(R.array.data_tv_release);
        dataTvDescription = getResources().getStringArray(R.array.data_tv_desc);
        dataTvPoster = getResources().obtainTypedArray(R.array.data_tv_poster);
    }

    private void showRecycleList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(getActivity());
        movieAdapter.setListMovie(list);
        rvCategory.setAdapter(movieAdapter);
    }
}