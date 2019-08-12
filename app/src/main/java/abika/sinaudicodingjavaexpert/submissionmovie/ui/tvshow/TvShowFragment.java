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
    private ArrayList<TVShow> tvShowsList = new ArrayList<>();
    private ProgressBar tvProgressbar;
    private TvShowAdapter tvAdapter;
    private RecyclerView tvRecycler;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TvShowViewModel tvViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
        tvViewModel.getTvShow();
        showLoading(true);
        tvViewModel.getListTv().observe(this, getTv);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvRecycler = view.findViewById(R.id.rv_list_tvshow);
        tvProgressbar = view.findViewById(R.id.pb_frag_tvshow);

        tvRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        tvAdapter = new TvShowAdapter(getActivity());
        tvAdapter.setTvShowList(tvShowsList);
        tvRecycler.setAdapter(tvAdapter);
        onItemClick();
    }

    private Observer<TvShowResponse> getTv = new Observer<TvShowResponse>() {
        @Override
        public void onChanged(@Nullable TvShowResponse tvShowResponse) {
            tvAdapter.setData(tvShowResponse);
            showLoading(false);
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            tvProgressbar.setVisibility(View.VISIBLE);
        } else {
            tvProgressbar.setVisibility(View.GONE);
        }
    }

    private void onItemClick() {
        ItemClickSupport.addTo(tvRecycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), TvShowDetailActivity.class);
                intent.putExtra(TvShowDetailActivity.EXTRA_DATA, tvShowsList.get(position));
                startActivity(intent);
            }
        });
    }
}