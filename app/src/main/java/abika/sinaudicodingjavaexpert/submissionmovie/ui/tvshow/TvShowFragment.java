package abika.sinaudicodingjavaexpert.submissionmovie.ui.tvshow;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.adapter.TvShowAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.data.TvShowResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TVShow;
import abika.sinaudicodingjavaexpert.submissionmovie.utils.ItemClickSupport;

public class TvShowFragment extends Fragment {
    private ArrayList<TVShow> tvList = new ArrayList<>();
    private ProgressBar mvProgressbar;
    private TvShowAdapter mvAdapter;
    private RecyclerView mvRecycler;

    public TvShowFragment(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TvShowViewModel mvViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
        mvViewModel.getTvShow(getContext());
        showLoading(true);
        mvViewModel.gettvList().observe(this, getTv);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvRecycler = view.findViewById(R.id.rv_list_tvshow);
        mvProgressbar = view.findViewById(R.id.pb_frag_tvshow);

        mvRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mvAdapter = new TvShowAdapter(getActivity());
        mvAdapter.setTvShowList(tvList);
        mvRecycler.setAdapter(mvAdapter);
        onItemClick();
    }

    private Observer<TvShowResponse> getTv = new Observer<TvShowResponse>() {
        @Override
        public void onChanged(@Nullable TvShowResponse tvShowResponse) {
            mvAdapter.setData(tvShowResponse);
            showLoading(false);
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            mvProgressbar.setVisibility(View.VISIBLE);
        } else {
            mvProgressbar.setVisibility(View.GONE);
        }
    }

    private void onItemClick() {
        ItemClickSupport.addTo(mvRecycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), TvShowDetailActivity.class);
                intent.putExtra(TvShowDetailActivity.EXTRA_DATA, tvList.get(position));
                startActivity(intent);
            }
        });
    }
}