package com.example.user.pmdproject;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;

import static android.R.attr.bitmap;
import static com.example.user.pmdproject.R.id.bnve;

public class MainActivity extends AppCompatActivity {

    //array warna icon dan text ketika tab navigasi di-klik (secara berurutan dari Home, Daily, Challenge, Favorites dan More)
    public static String[] colorNavs = new String[] {"#00D22C", "#ED5F5E", "#F5A622", "#2B96DA", "#00D22C"};
    public static ArrayList<Comix> comics;
    public static ArrayList<Comix> favorites;
    public static ArrayList<Comix> romance;
    public static ArrayList<Comix> drama;
    public static ArrayList<Comix> fantasy;
    public static ArrayList<Comix> comedy;
    public static ArrayList<Comix> thriller;
    public static ArrayList<Comix> horror;
    public static ArrayList<Comix> sol;

    public static UnSwipeableViewPager viewPager;
    private static Handler handler;
    private static Timer timer;
    private static TimerTask timerTask;
    private static Runnable Update;

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
        viewPager = (UnSwipeableViewPager) findViewById(R.id.mainvp);
        final Nav_PA pagerAdapter = new Nav_PA(getSupportFragmentManager(), bnve.getItemCount());

        //set PageAdaper pada ViewPager
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);

        //Hubungkan BottomNavigationViewEx dengan ViewPager
        bnve.setupWithViewPager(viewPager);

        favorites = new ArrayList<Comix>();
        comics = new ArrayList<Comix>();
        romance = new ArrayList<Comix>();
        drama = new ArrayList<Comix>();
        fantasy = new ArrayList<Comix>();
        comedy = new ArrayList<Comix>();
        thriller = new ArrayList<Comix>();
        horror = new ArrayList<Comix>();
        sol = new ArrayList<Comix>();

        comics.add(new Comix("Blessed", "M. Victoria Robado", "Joanna is a mid-twenties office girl who likes social media and watered down office. While griping about her love life, she accidentally swiped right on a whole Pantheon of Gods and Goddesses! Looking to fulfill an ancient prophecy, only one of them will be able to claim Joanna as their own... after a nice dinner, that is!", "cover/Blessed.jpg", Comix.Genre.DRAMA, 776271));
        comics.get(0).chapters.add(new Chapters(this, "Dear Joanna #1!", new GregorianCalendar(2017, 10, 24), "content/Drama/Blessed/Sampul Chapter/10.png", "comic/content/Drama/Blessed/10"));
        comics.add(new Comix("Adventures of God", "Matteo & Corey", "Follow God's mishaps in Heaven - as a ruler who's often forgetful, has a fragile ego, and a drinking problem.", "cover/Adventures of God.jpg", Comix.Genre.COMEDY, 776271));
        comics.get(1).chapters.add(new Chapters(this, "The Box", new GregorianCalendar(2017, 10, 25), "content/Comedy/Adventures of God/Sampul Chapter/84.png", "comic/content/Comedy/Adventures of God/ep84"));
        comics.add(new Comix("unOrdinary", "uru-chan", "The world is not perfect. Learning to deal with its flaws is just a normal part of life. But there comes a point where these imperfections spawn a crushing realization... that something needs tp change...", "cover/unOrdinary.jpg", Comix.Genre.FANTASY, 776271));
        comics.get(2).chapters.add(new Chapters(this, "Episode 65", new GregorianCalendar(2017, 8, 28), "content/Fantasy/unOrdinary/sampul chapter/67_ep65.png", "comic/content/Fantasy/unOrdinary/ep65"));
        comics.add(new Comix("Eggnoid", "Archie The RedCat", "Hidup Ran yang kesepian jadi lebih berwarna akibat kehadiran Eggy. Cowok ganteng ini keluar dari telur misterius yang muncul di kamar Ran. Tetapi... Eggy tingkahnya seperti anak ayam yang baru menetas! Kira-kira dari mana asalnya ya?", "cover/Eggnoid.jpg", Comix.Genre.ROMANCE, 776271));
        comics.get(3).chapters.add(new Chapters(this, "Ep. 9", new GregorianCalendar(2016, 0, 24), "content/Romance/Eggnoid/Sampul Chapter/ep9.png", "comic/content/Romance/Eggnoid/ep9"));
        comics.add(new Comix("Small World", "Wonsun Jin", "What do you do when you're having a bad day? Need a hug? Or just a laugh? Call your boyfriend of course! Follow along with Robin and Julien as they navigate in their own small world.", "cover/Small World.jpg", Comix.Genre.SLICE_OF_LIFE, 776271));
        comics.get(4).chapters.add(new Chapters(this, "Ep. 43 - Chibi", new GregorianCalendar(2017, 10, 21), "content/Slice of Life/Small World/Sampul Chapter/43.png", "comic/content/Slice of Life/Small World/ep43"));
        comics.add(new Comix("Melvina's Therapy", "A.Rasen", "Anxiety, loneliness, depression... with a regular therapy you can deal with these issues, but Melvina's Therapy is about something deeper: creepy secrets remaining in the darkest space of your mind, waiting for you...", "cover/Melvina's Therapy.jpg", Comix.Genre.HORROR, 776271));
        comics.get(5).chapters.add(new Chapters(this, "Ep. 10 - Chairs (4)", new GregorianCalendar(2017, 5, 22), "content/Horror/Melvina's Therapy/Sampul Chapter/10.png", "comic/content/Horror/Melvina's Therapy/ep10"));

        for(int i=0; i < comics.size(); i++) {
            Comix temp = comics.get(i);
            if(temp.genre == Comix.Genre.ROMANCE) romance.add(temp);
            else if(temp.genre == Comix.Genre.DRAMA) drama.add(temp);
            else if(temp.genre == Comix.Genre.FANTASY) fantasy.add(temp);
            else if(temp.genre == Comix.Genre.COMEDY) comedy.add(temp);
            else if(temp.genre == Comix.Genre.THRILLER) thriller.add(temp);
            else if(temp.genre == Comix.Genre.HORROR) horror.add(temp);
            else if(temp.genre == Comix.Genre.SLICE_OF_LIFE) sol.add(temp);
        }

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

    public static String[] getBitmapsFromSubFolder(Context context, String fileName) {
        String[] chapterImgs = null;
        InputStream istr;
        AssetManager asm = context.getAssets();
        ArrayList<Bitmap> bms = new ArrayList<Bitmap>();
        Bitmap bitmap = null;
        try {
            chapterImgs = asm.list(fileName.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(chapterImgs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                try {
                    int i1 = Integer.parseInt(s1.substring(0, s1.lastIndexOf('.')));
                    int i2 = Integer.parseInt(s2.substring(0, s2.lastIndexOf('.')));
                    return i1 - i2;
                } catch(NumberFormatException e) {
                    throw new AssertionError(e);
                }
            }
        });
        return chapterImgs;
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
    public static Bitmap getBitmapPublicFromAssets(Context context, String fileName) {
        AssetManager asm = context.getAssets();
        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = asm.open(fileName);
            bitmap = BitmapFactory.decodeStream(istr);
            istr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    public static Drawable getDrawablePublicFromAssets(Context context, String fileName) {
        AssetManager asm = context.getAssets();
        InputStream istr;
        Drawable d = null;
        try {
            istr = asm.open(fileName);
            d = Drawable.createFromStream(istr, null);
            istr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return d;
    }
    public void toFavorite(View v){
        MainActivity.viewPager.setCurrentItem(3, false);
        Fav_Fragment.favvp.setCurrentItem(0, false);
    }

    public void toDaily(View v){
        MainActivity.viewPager.setCurrentItem(1, false);
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1)
            dayOfWeek = 8;
        Daily_Fragment.dailyvp.setCurrentItem(dayOfWeek - 2, false);
    }
}
