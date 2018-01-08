package com.example.user.pmdproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.pmdproject.fragments.challenge.fragments.Challenge_Fragment;
import com.example.user.pmdproject.fragments.daily.fragments.Daily_Fragment;
import com.example.user.pmdproject.fragments.fav.fragments.Fav_Fragment;
import com.example.user.pmdproject.fragments.home.fragments.Home_Fragment;
import com.example.user.pmdproject.fragments.more.fragments.More_Fragment;

/**
 * Created by User on 20/11/2017.
 */

public class Nav_PA extends FragmentStatePagerAdapter {

    int navNoOfTabs;

    //sebuah constructor kelas PageAdapter
    public Nav_PA(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.navNoOfTabs = noOfTabs;
    }

    //Fragment apa yang diambil ketika navigasi di-klik user
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

    //mengembalikan jumlah tab navigasi yang akan digunakan pada BottomNavigationViewEx
    @Override
    public int getCount() {
        return navNoOfTabs;
    }
}
