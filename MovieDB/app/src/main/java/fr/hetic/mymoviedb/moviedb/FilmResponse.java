package fr.hetic.mymoviedb.moviedb;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmResponse implements Parcelable {

    private String title;
    private double vote_average;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    private String overview;


    public FilmResponse() {}

    protected FilmResponse(Parcel in) {
        // IN ORDER TO GIVE THE FILM TO AN ACTIVITY YOU SHOULD USE THE PARCELABLE IMPLEMENTATION
        title = in.readString();
        vote_average = in.readDouble();
        poster_path = in.readString();
        backdrop_path = in.readString();
        release_date = in.readString();
        overview = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // IN ORDER TO GIVE THE FILM TO AN ACTIVITY YOU SHOULD USE THE PARCELABLE IMPLEMENTATION
        dest.writeString(title);
        dest.writeDouble(vote_average);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeString(release_date);
        dest.writeString(overview);
    }

    @Override
    public int describeContents() {
        // IN ORDER TO GIVE THE FILM TO AN ACTIVITY YOU SHOULD USE THE PARCELABLE IMPLEMENTATION
        return 0;
    }

    public static final Creator<FilmResponse> CREATOR = new Creator<FilmResponse>() {
        // IN ORDER TO GIVE THE FILM TO AN ACTIVITY YOU SHOULD USE THE PARCELABLE IMPLEMENTATION
        @Override
        public FilmResponse createFromParcel(Parcel in) {
            return new FilmResponse(in);
        }

        @Override
        public FilmResponse[] newArray(int size) {
            return new FilmResponse[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
