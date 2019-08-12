package abika.sinaudicodingjavaexpert.submissionmovie.ui.movies;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import abika.sinaudicodingjavaexpert.submissionmovie.data.MovieResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.network.ApiRepository;
import abika.sinaudicodingjavaexpert.submissionmovie.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {
    private MutableLiveData<MovieResponse> movieList;

    public MoviesViewModel() {
        movieList = new MutableLiveData<>();
    }

    public void getMovie() {
        ApiService.create()
                .create(ApiRepository.class)
                .getMovies()
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                        movieList.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.d("onFailure: ", t.getMessage());
                    }
                });
    }

    public LiveData<MovieResponse> getListMovie() {
        return movieList;
    }
}
