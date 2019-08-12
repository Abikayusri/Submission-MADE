package abika.sinaudicodingjavaexpert.submissionmovie.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;

public class MovieResponse {
    @SerializedName("results")
    private List<Movie> moviesList = new ArrayList<>();

    public List<Movie> getMoviesList() {
        return moviesList;
    }
}
