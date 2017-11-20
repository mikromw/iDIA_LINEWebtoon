package com.example.user.pmdproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by User on 20/11/2017.
 */

public class Nav_PA extends FragmentStatePagerAdapter {

    int navNoOfTabs;

    public Nav_PA(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.navNoOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                Home_Fragment home = new Home_Fragment();
                return home;
            case 1:
                Daily_Fragment daily = new Daily_Fragment();
                return daily;
            case 2:
                Challenge_Fragment challenge = new Challenge_Fragment();
                return challenge;
            case 3:
                Fav_Fragment fav = new Fav_Fragment();
                return fav;
            case 4:
                More_Fragment more = new More_Fragment();
                return more;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return navNoOfTabs;
    }
}
