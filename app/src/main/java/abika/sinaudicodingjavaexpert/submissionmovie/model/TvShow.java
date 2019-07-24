package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String tvshowName, tvshowDescription, tvshowRelease, tvshowGenre;
    private String tvshowRating;
    private int imgResource;


    public String getTvshowGenre() {
        return tvshowGenre;
    }

    public void setTvshowGenre(String tvshowGenre) {
        this.tvshowGenre = tvshowGenre;
    }

    public String getTvshowRating() {
        return tvshowRating;
    }

    public void setTvshowRating(String tvshowRating) {
        this.tvshowRating = tvshowRating;
    }

    public String getTvshowName() {
        return tvshowName;
    }

    public void setTvshowName(String tvshowName) {
        this.tvshowName = tvshowName;
    }

    public String getTvshowDescription() {
        return tvshowDescription;
    }

    public void setTvshowDescription(String tvshowDescription) {
        this.tvshowDescription = tvshowDescription;
    }

    public String getTvshowRelease() {
        return tvshowRelease;
    }

    public void setTvshowRelease(String tvshowRelease) {
        this.tvshowRelease = tvshowRelease;
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
        dest.writeString(this.tvshowName);
        dest.writeString(this.tvshowDescription);
        dest.writeString(this.tvshowRelease);
        dest.writeString(this.tvshowGenre);
        dest.writeFloat(Float.parseFloat(String.valueOf(this.tvshowRating)));
        dest.writeInt(this.imgResource);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.tvshowName = in.readString();
        this.tvshowDescription = in.readString();
        this.tvshowRelease = in.readString();
        this.tvshowGenre = in.readString();
        this.tvshowRating = String.valueOf(in.readFloat());
        this.imgResource = in.readInt();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
