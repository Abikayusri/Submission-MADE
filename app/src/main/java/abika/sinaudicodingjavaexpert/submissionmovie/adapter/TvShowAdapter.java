package abika.sinaudicodingjavaexpert.submissionmovie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import abika.sinaudicodingjavaexpert.submissionmovie.BuildConfig;
import abika.sinaudicodingjavaexpert.submissionmovie.R;
import abika.sinaudicodingjavaexpert.submissionmovie.data.TvShowResponse;
import abika.sinaudicodingjavaexpert.submissionmovie.model.TVShow;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvViewHolder> {
    private final Context context;

    private ArrayList<TVShow> tvList = new ArrayList<>();
    public TvShowAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<TVShow> getTvList() { return tvList; }

    public void setTvShowList(ArrayList<TVShow> tvList) {
        this.tvList = tvList;
    }


    public void setData(TvShowResponse items) {
        tvList.clear();
        tvList.addAll(items.getTvShowList());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new TvViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvViewHolder tvViewHolder, final int position) {
        tvViewHolder.txtMovieTitle.setText(tvList.get(position).getTVShowName());
        tvViewHolder.txtMovieDescription.setText(tvList.get(position).getTVShowOverview());
        tvViewHolder.txtMovieRating.setText(String.valueOf(tvList.get(position).getTVShowRating()));
        tvViewHolder.getAdapterPosition();

        Log.d("TvShowAdapter", "Status Data: " + tvList.get(position).getTVShowName());
        Log.d("TvShowAdapter", "Status Data: " + tvList.get(position).getTvOrName());
        Log.d("TvShowAdapter", "Status Data: " + tvList.get(position).getTVShowOverview());
        Log.d("TvShowAdapter", "Status Data: " + tvList.get(position).getTVShowRating());

        Glide.with(context)
                .load(BuildConfig.URL_POSTER + getTvList()
                        .get(position)
                        .getTVShowPoster())
                .into(tvViewHolder.imgMoviePoster);
    }

    @Override
    public int getItemCount() { return getTvList().size(); }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        final TextView txtMovieTitle;
        final TextView txtMovieDescription;
        final TextView txtMovieGenre;
        final TextView txtMovieRating;
        final ImageView imgMoviePoster;

        TvViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMovieTitle = itemView.findViewById(R.id.tv_item_name);
            txtMovieDescription = itemView.findViewById(R.id.tv_item_desc);
            txtMovieGenre = itemView.findViewById(R.id.tv_item_genre);
            txtMovieRating = itemView.findViewById(R.id.tv_item_rating);
            imgMoviePoster = itemView.findViewById(R.id.iv_item_photo);
        }
    }
}