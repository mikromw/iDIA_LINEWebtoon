package com.example.user.pmdproject;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.view.View;

import android.widget.GridView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;

import static android.R.attr.bitmap;
import static com.example.user.pmdproject.R.id.bnve;

public class MainActivity extends AppCompatActivity {

    //array warna icon dan text ketika tab navigasi di-klik (secara berurutan dari Home, Daily, Challenge, Favorites dan More)
    public static String[] colorNavs = new String[] {"#00D22C", "#ED5F5E", "#F5A622", "#2B96DA", "#00D22C"};
    public static ArrayList<Comix> comics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Pembuatan BottomNavigationViewEx
        //1. Tidak ada animasi ketika user meng-klik navigasi
        //2. Icon tetap dilengkapi dengan teks meskipun tab navigasi tidak di-klik (dipilih)
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setTextSize(10);

        //Pembuatan ViewPager dengan PageAdapter
        final UnSwipeableViewPager viewPager = (UnSwipeableViewPager) findViewById(R.id.mainvp);
        final Nav_PA pagerAdapter = new Nav_PA(getSupportFragmentManager(), bnve.getItemCount());

        //set PageAdaper pada ViewPager
        viewPager.setAdapter(pagerAdapter);

        //Hubungkan BottomNavigationViewEx dengan ViewPager
        bnve.setupWithViewPager(viewPager);

        comics = new ArrayList<Comix>();
        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", "cover/GOSU.jpg", Comix.Genre.DRAMA, 776271));
        comics.add(new Comix("Adventures of God", "Matteo & Corey", "Follow God's mishaps in Heaven - as a ruler who's often forgetful, has a fragile ego, and a drinking problem.", "cover/Adventures of God.jpg", Comix.Genre.KOMEDI, 776271));
        comics.get(0).chapters.add(new Chapters(this, "The Box", new GregorianCalendar(2017, 10, 25), "content/Comedy/Adventures of God/Sampul Chapter/84.png", "content/Comedy/Adventures of God/eps84"));

//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));
//        comics.add(new Comix("CHANGE", "JINONE", "Kenapa aku berubah jadi cewek?!", R.drawable.thumb_m, Comix.Genre.DRAMA, 776271));

        //set warna icon dan teks untuk semua tab di Bottom Navigation dalam kondisi tertentu
        for(int i=0; i < bnve.getItemCount(); i++) {
            bnve.setTextTintList(i, new ColorStateList(
                    new int[][] {
                            new int[] {android.R.attr.state_checked},
                            new int[] {android.R.attr.state_pressed},
                            new int[] {android.R.attr.state_selected},
                            new int[] {-android.R.attr.state_selected}
                    },
                    new int[] {
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.BLACK
                    })
            );
            bnve.setIconTintList(i, new ColorStateList(
                    new int[][] {
                            new int[] {android.R.attr.state_checked},
                            new int[] {android.R.attr.state_pressed},
                            new int[] {android.R.attr.state_selected},
                            new int[] {-android.R.attr.state_selected}
                    },
                    new int[] {
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.BLACK
                    })
            );
        }

    }

    public static Bitmap getBitmapFromAssets(Context context, String fileName) {
        AssetManager asm = context.getAssets();
        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = asm.open("comic/" + fileName);
            bitmap = BitmapFactory.decodeStream(istr);
            istr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static ArrayList<Bitmap> getBitmapsFromSubFolder(Context context, String fileName) {
        String[] chapterImgs;
        InputStream istr;
        AssetManager asm = context.getAssets();
        ArrayList<Bitmap> bms = new ArrayList<Bitmap>();
        Bitmap bitmap = null;
        try {
            chapterImgs = asm.list(fileName.replaceAll("/", Matcher.quoteReplacement(File.separator)));
            for(int i=0; i < chapterImgs.length; i++) {
                istr = asm.open("comic/" + chapterImgs[i]);
                bitmap = BitmapFactory.decodeStream(istr);
                bms.add(bitmap);
                istr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bms;
    }

    public static Drawable getDrawableFromAssets(Context context, String fileName) {
        AssetManager asm = context.getAssets();
        InputStream istr;
        Drawable d = null;
        try {
            istr = asm.open("comic/" + fileName);
            d = Drawable.createFromStream(istr, null);
            istr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return d;
    }
}
