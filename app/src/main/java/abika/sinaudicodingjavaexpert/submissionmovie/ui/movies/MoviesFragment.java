package abika.sinaudicodingjavaexpert.submissionmovie.ui.movies;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.data.MovieResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.MovieAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.utils.ItemClickSupport;

public class MoviesFragment extends Fragment {
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ProgressBar mvProgressbar;
    private MovieAdapter mvAdapter;
    private RecyclerView mvRecycler;

    public MoviesFragment(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MoviesViewModel mvViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        mvViewModel.getMovie();
        showLoading(true);
        mvViewModel.getListMovie().observe(this, getMovie);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvRecycler = view.findViewById(R.id.rv_list_movie);
        mvProgressbar = view.findViewById(R.id.pb_frag_movie);

        mvRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mvAdapter = new MovieAdapter(getActivity());
        mvAdapter.setMovieList(movieList);
        mvRecycler.setAdapter(mvAdapter);
        onItemClick();
    }

    private Observer<MovieResponse> getMovie = new Observer<MovieResponse>() {
        @Override
        public void onChanged(@Nullable MovieResponse movieResponse) {
            mvAdapter.setData(movieResponse);
            showLoading(false);
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            mvProgressbar.setVisibility(View.VISIBLE);
        } else {
            mvProgressbar.setVisibility(View.GONE);
        }
    }

    private void onItemClick() {
        ItemClickSupport.addTo(mvRecycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), MoviesDetailActivity.class);
                intent.putExtra(MoviesDetailActivity.EXTRA_DATA, movieList.get(position));
                startActivity(intent);
            }
        });
    }
}