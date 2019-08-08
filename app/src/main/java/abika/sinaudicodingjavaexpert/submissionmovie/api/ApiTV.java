package abika.sinaudicodingjavaexpert.submissionmovie.api;

import abika.sinaudicodingjavaexpert.submissionmovie.data.TvShowResponse;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ApiTV {
    @GET("tv/top_rated")
    Call<TvShowResponse> getTopRatedTvShow(@Query("api_key") String apiKey);
}
