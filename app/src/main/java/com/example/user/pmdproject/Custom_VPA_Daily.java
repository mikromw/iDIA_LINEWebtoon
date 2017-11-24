package com.example.user.pmdproject;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Custom_VPA_Daily extends PagerAdapter{
    private Context mContext;

    public Custom_VPA_Daily(Context context){
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position){
        Model_Object_Daily modelObject = Model_Object_Daily.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return Model_Object_Daily.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Model_Object_Daily customPagerEnum = Model_Object_Daily.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }
}
