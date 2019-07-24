package abika.sinaudicodingjavaexpert.submissionmovie.ui;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.MovieAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.TvshowAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TvShow;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    private String[] dataTvName;
    private String[] dataTvDescription;
    private String[] dataTvRelease;
    private String[] dataTvRate;
    private String[] dataTvGenre;
    private TypedArray dataTvPoster;

    private RecyclerView rvCategory;
    private final ArrayList<TvShow> list = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tvshow, container, false);
        rvCategory = v.findViewById(R.id.lv_list_tv);
        rvCategory.setHasFixedSize(true);

        prepare();
        addItem();

        showRecycleList();

        return v;
    }


    private void addItem() {
        ArrayList<TvShow> tvShows = new ArrayList<>();
        for (int i = 0; i < dataTvName.length; i++) {
            TvShow tvshow = new TvShow();
            tvshow.setImgResource(dataTvPoster.getResourceId(i, -1));
            tvshow.setTvshowName(dataTvName[i]);
            tvshow.setTvshowDescription(dataTvDescription[i]);
            tvshow.setTvshowRelease(dataTvRelease[i]);
            tvshow.setTvshowRating(dataTvRate[i]);
            tvshow.setTvshowGenre(dataTvGenre[i]);

            tvShows.add(tvshow);
        }
        list.addAll(tvShows);
    }

    private void prepare() {
        dataTvName = getResources().getStringArray(R.array.data_tv_name);
        dataTvRate = getResources().getStringArray(R.array.data_tv_rating);
        dataTvGenre = getResources().getStringArray(R.array.data_tv_genre);
        dataTvRelease = getResources().getStringArray(R.array.data_tv_release);
        dataTvDescription = getResources().getStringArray(R.array.data_tv_desc);
        dataTvPoster = getResources().obtainTypedArray(R.array.data_tv_poster);
    }

    private void showRecycleList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvshowAdapter tvshowAdapter = new TvshowAdapter(getActivity());
        tvshowAdapter.setListTvshow(list);
        rvCategory.setAdapter(tvshowAdapter);
    }
}