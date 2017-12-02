package com.example.user.pmdproject;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;

import static android.R.attr.bitmap;
import static com.example.user.pmdproject.MainActivity.getBitmapFromAssets;

/**
 * Created by User on 02/12/2017.
 */

public class Chapters implements Parcelable {
    private String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    private String title;
    public String coverImg;
    public String chapterDirs;
    private GregorianCalendar release;
//    public ArrayList<Bitmap> chapterThumbs;
    public Chapters(Context context, String title, GregorianCalendar release, String coverImg, String chapterDirs) {
        this.title = title;
        this.release = release;
        this.coverImg = coverImg;
        this.chapterDirs = chapterDirs;
//        AssetManager asm = context.getAssets();
//        InputStream istr;
//        Bitmap bitmap;
//        chapterThumbs = new ArrayList<Bitmap>();
//        try {
//            chapterImgs = asm.list("content" + File.separator + "Comedy.Adventures of God" + File.separator + "eps84");
//            istr = asm.open("comic/" + coverImg);
//            bitmap = BitmapFactory.decodeStream(istr);
//            chapterThumbs.add(bitmap);
////            for(int i=0; i < chapterImgs.length; i++) {
////                istr = asm.open("comic/" + chapterImgs[i]);
////                bitmap = BitmapFactory.decodeStream(istr);
////                chapterThumbs.add(bitmap);
////            }
//            istr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public String getChapterTitle() {
        return this.title;
    }
    public String getChapterDate() {
        return this.release.get(Calendar.DATE) + " " + months[this.release.get(Calendar.MONTH)] + " " + this.release.get(Calendar.YEAR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(months);
        parcel.writeString(title);
        parcel.writeSerializable(release);
        parcel.writeString(coverImg);
        parcel.writeString(chapterDirs);
//        parcel.writeTypedList(chapterThumbs);
    }

    protected Chapters(Parcel in) {
        in.readStringArray(months);
        title = in.readString();
        release = (GregorianCalendar)in.readSerializable();
        coverImg = in.readString();
        chapterDirs = in.readString();
//        chapterThumbs = in.createTypedArrayList(Bitmap.CREATOR);
    }

    public static final Parcelable.Creator<Chapters> CREATOR = new Parcelable.Creator<Chapters>() {


        @Override
        public Chapters createFromParcel(Parcel parcel) {
            return new Chapters(parcel);
        }

        @Override
        public Chapters[] newArray(int i) {
            return new Chapters[i];
        }
    };
}
