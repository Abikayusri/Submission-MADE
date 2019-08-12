package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TVShow implements Parcelable {
    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @SerializedName("name")
    private String tvName;

    @SerializedName("title")
    private String tvTitle;

    @SerializedName("poster_path")
    private String tvPoster;

    @SerializedName("overview")
    private String tvOverview;

    @SerializedName("id")
    private int tvId;

    @SerializedName("results")
    private ArrayList<TVShow> tvResult;

    public ArrayList<TVShow> getResult() {
        return tvResult;
    }

    @SerializedName("genres")
    private List<TVShow> tvGenre;

    @SerializedName("original_language")
    private String tvLanguage;

    @SerializedName("tagline")
    private String tvTagline;

    @SerializedName("runtime")
    private int tvRuntime;

    @SerializedName("first_air_date")
    private String tvRelease;

    @SerializedName("vote_average")
    private float tvRating;


    public List<TVShow> getTVShowGenre() {
        return tvGenre;
    }

    public void setTVShowGenre(List<TVShow> genres) {
        this.tvGenre = genres;
    }

    public void setTVShowRating(float vote_average) {
        this.tvRating= vote_average;
    }

    public float getTVShowRating() {
        return tvRating;
    }

    public String getTVShowRelease() {
        return tvRelease;
    }

    public void setTVShowRelease(String release_date) {
        this.tvRelease = release_date;
    }

    public String getTVShowTagline() {
        return tvTagline;
    }

    public void setTVShowTagline(String tagline) {
        this.tvTagline = tagline;
    }

    public String getTVShowLanguage() {
        return tvLanguage;
    }

    public void setTVShowLanguage(String original_language) {
        this.tvLanguage = original_language;
    }

    public int getTVShowRuntime() {
        return tvRuntime;
    }

    public void setTVShowRuntime(int runtime) {
        this.tvRuntime = runtime;
    }

    public String getTVShowName() {
        return tvName;
    }

    public void setTVShowName(String name) {
        this.tvName = name;
    }

    public int getTVShowId() {
        return tvId;
    }

    public void setTVShowId(int id) {
        this.tvId = id;
    }

    public String getTVShowTitle() {
        return tvTitle;
    }

    public void setTVShowTitle(String title) {
        this.tvTitle = title;
    }

    public String getTVShowPoster() {
        return tvPoster;
    }

    public void setTVShowPoster(String posterPath) {
        this.tvPoster = posterPath;
    }

    public String getTVShowOverview() {
        return tvOverview;
    }

    public void setTVShowOverview(String overview) {
        this.tvOverview = overview;
    }


    public TVShow() {
    }

    protected TVShow(Parcel in) {
        this.tvTitle = in.readString();
        this.tvPoster = in.readString();
        this.tvOverview = in.readString();
        this.tvRelease = in.readString();
        this.tvId = in.readInt();
        this.tvRating = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvTitle);
        dest.writeString(this.tvPoster);
        dest.writeString(this.tvOverview);
        dest.writeString(this.tvRelease);
        dest.writeInt(this.tvId);
        dest.writeFloat(this.tvRating);
    }
}
