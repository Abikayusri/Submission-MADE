package abika.sinaudicodingjavaexpert.submissionmovie.network;

import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.data.MovieResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.data.TvShowResponse;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ApiRepository {
    @GET("movie/popular?api_key=" + BuildConfig.API_KEY)
    Call<MovieResponse> getMovies();

    @GET("tv/popular?api_key=" + BuildConfig.API_KEY)
    Call<TvShowResponse> getTvShows();
}
