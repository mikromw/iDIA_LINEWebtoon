package com.example.user.pmdproject;

import android.media.Image;

/**
 * Created by User on 24/11/2017.
 */

public class Comix {
    public enum Genre {
        Drama, Fantasi, Komedi, Slice_of_Life, Romantis, Thriller, Horor
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
