package abika.sinaudicodingjavaexpert.submissionmovie.api;

import abika.sinaudicodingjavaexpert.submissionmovie.data.MovieResponse;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ApiMovie {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
