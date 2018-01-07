package com.example.user.pmdproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.w3c.dom.Comment;

/**
 * Created by User on 01/12/2017.
 */

public class FavPA extends FragmentStatePagerAdapter {
    private String[] pageTitles = new String[] {"TERBARU", "WEBTOON FAVORIT", "UNDUHAN", "KOMENTAR"};

    public FavPA(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                RecentsListFragment rec = new RecentsListFragment();
                return rec;
            case 1:
                WebFavsFragment wff = new WebFavsFragment();
                return wff;
            case 2:
                DownloadsFragment df = new DownloadsFragment();
                return df;
            case 3:
                CommentFragment cf = new CommentFragment();
                return cf;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageTitles.length;
    }
}
