package com.example.user.pmdproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by User on 26/11/2017.
 */

public class SchedulePA extends FragmentStatePagerAdapter {
    private String[] pageTitles = new String[] {"SEN", "SEL", "RAB", "KAM", "JUM", "SAB", "MIN", "EPISODE LENGKAP"};

    public SchedulePA(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return GridDailyFragment.newInstance();
    }

    @Override
    public int getCount() {
        return pageTitles.length;
    }
}
