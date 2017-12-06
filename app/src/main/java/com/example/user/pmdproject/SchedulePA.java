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
        switch(position) {
            case 0:
                Monday_Fragment mon = new Monday_Fragment();
                return mon;
            case 1:
                Tuesday_Fragment tue = new Tuesday_Fragment();
                return tue;
            case 2:
                Wednesday_Fragment wed = new Wednesday_Fragment();
                return wed;
            case 3:
                Thursday_Fragment thu = new Thursday_Fragment();
                return thu;
            case 4:
                Friday_Fragment fri = new Friday_Fragment();
                return fri;
            case 5:
                Saturday_Fragment sat = new Saturday_Fragment();
                return sat;
            case 6:
                Sunday_Fragment sun = new Sunday_Fragment();
                return sun;
            case 7:
                Completed_Fragment comp = new Completed_Fragment();
                return comp;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageTitles.length;
    }
}
