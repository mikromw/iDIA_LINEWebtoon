package com.example.user.pmdproject;

import android.media.Image;

/**
 * Created by User on 24/11/2017.
 */

public class Comix {
    public enum Genre {
        DRAMA("Drama", 0xFF00B19A),
        FANTASI("Fantasi", 0xFF8B00E9),
        KOMEDI("Komedi", 0xFFEEA800),
        SlICE_OF_LIFE("Slice Of Life", 0xFF9AB710),
        ROMANTIS("Romantis", 0xFFFD337F),
        THRILLER("Thriller", 0xFFC00355),
        HOROR("Horor", 0xFFBE0000);

        private final String genre_name;
        private final int genre_colorid;

        private Genre(String genre_name, int genre_colorid) {
            this.genre_name = genre_name;
            this.genre_colorid = genre_colorid;
        }

        public String getName() {
            return genre_name;
        }

        public int getColor() {
            return genre_colorid;
        }
    }
    public long likes;
    public int imgs;
//    public String[] episodes;
    public String descr;
    public String author;
    public String title;
    public Genre genre;
    public boolean isVisited;
    public Comix(String title, String author, String descr, int imgs, Genre genre, long likes) {
        this.title = title;
        this.author = author;
        this.descr = descr;
        this.imgs = imgs;
        this.genre = genre;
        this.likes = likes;
        this.isVisited = false;
    }
}
