package abika.sinaudicodingjavaexpert.submissionmovie.ui.movies;


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
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.MovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String[] dataMovieName;
    private String[] dataMovieDescription;
    private String[] dataMovieRelease;
    private String[] dataMovieRate;
    private String[] dataMovieGenre;
    private TypedArray dataMoviePoster;

    private RecyclerView rvCategory;
    private final ArrayList<Movie> list = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movies, container, false);
        rvCategory = v.findViewById(R.id.rv_list_movie);
        rvCategory.setHasFixedSize(true);

        prepare();
        addItem();

        showRecycleList();

        return v;
    }


    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < dataMovieName.length; i++) {
            Movie movie = new Movie();
            movie.setImgResource(dataMoviePoster.getResourceId(i, -1));
            movie.setMovieName(dataMovieName[i]);
            movie.setMovieDescription(dataMovieDescription[i]);
            movie.setMovieRelease(dataMovieRelease[i]);
            movie.setMovieRating(dataMovieRate[i]);
            movie.setMovieGenre(dataMovieGenre[i]);

            movies.add(movie);
        }
        list.addAll(movies);
    }

    private void prepare() {
        dataMovieName = getResources().getStringArray(R.array.data_movie_name);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rating);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataMovieRelease = getResources().getStringArray(R.array.data_movie_release);
        dataMovieDescription = getResources().getStringArray(R.array.data_movie_desc);
        dataMoviePoster = getResources().obtainTypedArray(R.array.data_movie_poster);
    }

    private void showRecycleList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(getActivity());
        movieAdapter.setListMovie(list);
        rvCategory.setAdapter(movieAdapter);
    }
}

