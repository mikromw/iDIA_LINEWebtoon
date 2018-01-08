package com.example.user.pmdproject.fragments.home.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.user.pmdproject.fragments.home.fragments.Home_Carousel_Fragment;


/**
 * Created by Windows10 on 08/12/2017.
 */

public class HomeCarouselAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private final int page = Integer.MAX_VALUE;
    private ViewGroup mContainer;
    private final Home_Carousel_Fragment[] images = {
            Home_Carousel_Fragment.newInstance(0), Home_Carousel_Fragment.newInstance(1), Home_Carousel_Fragment.newInstance(2),
            Home_Carousel_Fragment.newInstance(3), Home_Carousel_Fragment.newInstance(4)
    };

    public HomeCarouselAdapter(FragmentManager fm, Context mContext, ViewGroup container){
        super(fm);
        this.mContext = mContext;
        this.mContainer = container;
    }

    @Override
    public Fragment getItem(int position) {
        return images[position % 5];
    }

    @Override
    public int getCount() {
        return page;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
