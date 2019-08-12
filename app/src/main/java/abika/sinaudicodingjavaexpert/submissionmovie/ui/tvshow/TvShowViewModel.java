package abika.sinaudicodingjavaexpert.submissionmovie.ui.tvshow;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    private MutableLiveData<TvShowResponse> tvList;

    public TvShowViewModel() {
        tvList = new MutableLiveData<>();
    }

    public void getTvShow(Context context) {
        ApiService.create()
                .create(ApiRepository.class)
                .getTvShows()
                .enqueue(new Callback<TvShowResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<TvShowResponse> call, @NonNull Response<TvShowResponse> response) {
                        tvList.postValue(response.body());
                        Toast.makeText(context,"Succes Load Data", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<TvShowResponse> call, Throwable t) {
                        Log.d("onFailure: ", t.getMessage());
                        Toast.makeText(context,"Error Load Data", Toast.LENGTH_LONG).show();
                    }
                });

    }

    public LiveData<TvShowResponse> gettvList() {
        return tvList;
    }
}
