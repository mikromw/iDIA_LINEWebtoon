package com.example.user.pmdproject.fragments.more.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.pmdproject.fragments.more.fragments.GridViewFragment;

/**
 * Created by User on 07/01/2018.
 */

public class GenrePA extends FragmentStatePagerAdapter {

    private String[] pageTitles = new String[] {"ROMANTIS", "DRAMA", "FANTASI", "KOMEDI", "THRILLER", "HOROR", "SLICE OF LIFE"};
    public GenrePA(FragmentManager fm) {
        super(fm);
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
