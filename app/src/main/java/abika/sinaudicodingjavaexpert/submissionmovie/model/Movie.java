package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String movieName, movieDescription, movieRelease, movieGenre;
    private String movieRating;
    private int imgResource;


    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(String movieRelease) {
        this.movieRelease = movieRelease;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieName);
        dest.writeString(this.movieDescription);
        dest.writeString(this.movieRelease);
        dest.writeString(this.movieGenre);
        dest.writeFloat(Float.parseFloat(String.valueOf(this.movieRating)));
        dest.writeInt(this.imgResource);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.movieName = in.readString();
        this.movieDescription = in.readString();
        this.movieRelease = in.readString();
        this.movieGenre = in.readString();
        this.movieRating = String.valueOf(in.readFloat());
        this.imgResource = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}