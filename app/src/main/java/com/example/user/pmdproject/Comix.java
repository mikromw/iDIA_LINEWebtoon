package com.example.user.pmdproject;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24/11/2017.
 */

public class Comix implements Parcelable {

    public enum Genre implements Parcelable {
        FANTASY("Fantasy", "Immerse, Imagine, and Inspire.", 0xFF8B00E9),
        COMEDY("Comedy", "Good Laughter is all we need.", 0xFFEEA800),
        DRAMA("Drama", "", 0xFF00B19A),
        SLICE_OF_LIFE("Slice Of Life", "", 0xFF9AB710),
        ROMANCE("Romance", "", 0xFFFD337F),
        THRILLER("Thriller", "", 0xFFC00355),
        HORROR("Horror", "", 0xFFBE0000),
        ACTION("Action", "", 0xFF006AFA),
        SUPERHERO("Superhero", "", 0xFF4A20E2),
        HEARTWARMING("Heartwarming", "", 0xFFFD6900),
        SPORTS("Sports", "", 0xFF1BA8F2),
        SCI_FI("Sci-Fi", "", 0xFF2D4464);

        private final String genre_name;
        private final String genre_description;
        private final int genre_colorid;

        private Genre(String genre_name, String genre_description, int genre_colorid) {
            this.genre_name = genre_name;
            this.genre_description = genre_description;
            this.genre_colorid = genre_colorid;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(ordinal());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Genre> CREATOR = new Creator<Genre>() {
            @Override
            public Genre createFromParcel(Parcel in) {
                return Genre.values()[in.readInt()];
            }

            @Override
            public Genre[] newArray(int size) {
                return new Genre[size];
            }
        };

        public String getName() {
            return genre_name;
        }

        public String getDescription() {
            return genre_description;
        }

        public int getColor() {
            return genre_colorid;
        }
    }
    public long likes;
    public String thumbnail;
    public ArrayList<Chapters> chapters;
    public String descr;
    public String author;
    public String title;
    public Genre genre;
    public boolean isVisited;
    public Comix(String title, String author, String descr, String thumbnail, Genre genre, long likes) {
        this.title = title;
        this.author = author;
        this.descr = descr;
        this.thumbnail = thumbnail;
        this.genre = genre;
        this.likes = likes;
        this.isVisited = false;
        this.chapters = new ArrayList<Chapters>();
    }

    protected Comix(Parcel in) {
        likes = in.readLong();
        thumbnail = in.readString();
        chapters = in.createTypedArrayList(Chapters.CREATOR);
        descr = in.readString();
        author = in.readString();
        title = in.readString();
        isVisited = in.readByte() != 0;
        genre = in.readParcelable(Genre.class.getClassLoader());
    }
    public static final Parcelable.Creator<Comix> CREATOR = new Parcelable.Creator<Comix>() {

        @Override
        public Comix createFromParcel(Parcel parcel) {
            return new Comix(parcel);
        }

        @Override
        public Comix[] newArray(int i) {
            return new Comix[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(likes);
        parcel.writeString(thumbnail);
        parcel.writeTypedList(chapters);
        parcel.writeString(descr);
        parcel.writeString(author);
        parcel.writeString(title);
        parcel.writeByte((byte) (isVisited ? 1 : 0));
        parcel.writeParcelable(genre, i);
    }

}
