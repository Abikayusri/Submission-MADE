package abika.sinaudicodingjavaexpert.submissionmovie.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import abika.sinaudicodingjavaexpert.submissionmovie.model.TVShow;

public class TvShowResponse {
    @SerializedName("results")
    private List<TVShow> tvShowList = new ArrayList<>();

    public List<TVShow> getTvShowList() {
        return tvShowList;
    }
}
