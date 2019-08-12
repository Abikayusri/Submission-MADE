package abika.sinaudicodingjavaexpert.submissionmovie.ui.tvshow;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import abika.sinaudicodingjavaexpert.submissionmovie.data.TvShowResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.network.ApiRepository;
import abika.sinaudicodingjavaexpert.submissionmovie.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowViewModel extends ViewModel {
    private MutableLiveData<TvShowResponse> listTv;

    public TvShowViewModel() {
        listTv = new MutableLiveData<>();
    }

    public void getTvShow() {
        ApiService.create()
                .create(ApiRepository.class)
                .getTvShows()
                .enqueue(new Callback<TvShowResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<TvShowResponse> call, @NonNull Response<TvShowResponse> response) {
                        listTv.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<TvShowResponse> call, Throwable t) {
                        Log.d("onFailure: ", t.getMessage());
                    }
                });

    }

    public LiveData<TvShowResponse> getListTv() {
        return listTv;
    }
}
