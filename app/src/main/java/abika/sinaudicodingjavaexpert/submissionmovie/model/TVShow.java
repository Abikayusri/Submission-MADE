package abika.sinaudicodingjavaexpert.submissionmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    protected TVShow(Parcel in) {
    }

    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
