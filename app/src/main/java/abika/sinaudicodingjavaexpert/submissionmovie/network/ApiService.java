package abika.sinaudicodingjavaexpert.submissionmovie.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static Retrofit create() {
        Gson gson = new GsonBuilder().create();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
