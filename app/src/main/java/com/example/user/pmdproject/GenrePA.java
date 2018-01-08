package com.example.user.pmdproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 07/01/2018.
 */

public class GenrePA extends FragmentStatePagerAdapter {

    private String[] pageTitles = new String[] {"ROMANTIS", "DRAMA", "FANTASI", "KOMEDI", "THRILLER", "HOROR", "SLICE OF LIFE"};
    public Fragment[] fragments;
    public GenrePA(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[pageTitles.length];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return GridViewFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return pageTitles.length;
    }
}
