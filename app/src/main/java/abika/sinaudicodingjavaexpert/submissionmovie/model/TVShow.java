package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import abika.sinaudicodingjavaexpert.submissionmovie.adapter.TvshowAdapter;

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
    private String movieName;

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("poster_path")
    private String moviePoster;

    @SerializedName("overview")
    private String movieOverview;

    @SerializedName("id")
    private int movieId;

    @SerializedName("results")
    private ArrayList<TVShow> movieResult;

    public ArrayList<TVShow> getResult() {
        return movieResult;
    }

    @SerializedName("genres")
    private List<TVShow> movieGenre;

    @SerializedName("original_language")
    private String movieLanguage;

    @SerializedName("tagline")
    private String movieTagline;

    @SerializedName("runtime")
    private int movieRuntime;

    @SerializedName("release_date")
    private String movieRelease;

    @SerializedName("vote_average")
    private float movieRating;


    public List<TVShow> getTVShowGenre() {
        return movieGenre;
    }

    public void setTVShowGenre(List<TVShow> genres) {
        this.movieGenre = genres;
    }

    public void setTVShowRating(float vote_average) {
        this.movieRating= vote_average;
    }

    public float getTVShowRating() {
        return movieRating;
    }

    public String getTVShowRelease() {
        return movieRelease;
    }

    public void setTVShowRelease(String release_date) {
        this.movieRelease = release_date;
    }

    public String getTVShowTagline() {
        return movieTagline;
    }

    public void setTVShowTagline(String tagline) {
        this.movieTagline = tagline;
    }

    public String getTVShowLanguage() {
        return movieLanguage;
    }

    public void setTVShowLanguage(String original_language) {
        this.movieLanguage = original_language;
    }

    public int getTVShowRuntime() {
        return movieRuntime;
    }

    public void setTVShowRuntime(int runtime) {
        this.movieRuntime = runtime;
    }

    public String getName() {
        return movieName;
    }

    public void setName(String name) {
        this.movieName = name;
    }

    public int getTVShowId() {
        return movieId;
    }

    public void setTVShowId(int id) {
        this.movieId = id;
    }

    public String getTVShowTitle() {
        return movieTitle;
    }

    public void setTVShowTitle(String title) {
        this.movieTitle = title;
    }

    public String getTVShowPoster() {
        return moviePoster;
    }

    public void setTVShowPoster(String posterPath) {
        this.moviePoster = posterPath;
    }

    public String getTVShowOverview() {
        return movieOverview;
    }

    public void setTVShowOverview(String overview) {
        this.movieOverview = overview;
    }


    public TVShow() {
    }

    protected TVShow(Parcel in) {
        this.movieTitle = in.readString();
        this.moviePoster = in.readString();
        this.movieOverview = in.readString();
        this.movieId = in.readInt();
        this.movieRating = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieTitle);
        dest.writeString(this.moviePoster);
        dest.writeString(this.movieOverview);
        dest.writeInt(this.movieId);
        dest.writeFloat(this.movieRating);
    }
}
