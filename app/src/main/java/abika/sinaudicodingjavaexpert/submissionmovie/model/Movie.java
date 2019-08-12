package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
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
    private ArrayList<Movie> movieResult;

    public ArrayList<Movie> getResult() {
        return movieResult;
    }

    @SerializedName("genres")
    private List<Movie> movieGenre;

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


    public List<Movie> getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(List<Movie> genres) {
        this.movieGenre = genres;
    }

    public void setMovieRating(float vote_average) {
        this.movieRating= vote_average;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(String release_date) {
        this.movieRelease = release_date;
    }

    public String getMovieTagline() {
        return movieTagline;
    }

    public void setMovieTagline(String tagline) {
        this.movieTagline = tagline;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String original_language) {
        this.movieLanguage = original_language;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(int runtime) {
        this.movieRuntime = runtime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String name) {
        this.movieName = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int id) {
        this.movieId = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String title) {
        this.movieTitle = title;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String posterPath) {
        this.moviePoster = posterPath;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String overview) {
        this.movieOverview = overview;
    }


    public Movie() {
    }

    protected Movie(Parcel in) {
        this.movieTitle = in.readString();
        this.moviePoster = in.readString();
        this.movieOverview = in.readString();
        this.movieRelease = in.readString();
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
        dest.writeString(this.movieRelease);
        dest.writeInt(this.movieId);
        dest.writeFloat(this.movieRating);
    }
}