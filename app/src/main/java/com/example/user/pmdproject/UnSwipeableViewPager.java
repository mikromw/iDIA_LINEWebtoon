package com.example.user.pmdproject;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by User on 21/11/2017.
 */

//sebuah kelas yang di-custom agar ViewPager tidak bisa di-swipe (digeser)
public class UnSwipeableViewPager extends ViewPager{
    public UnSwipeableViewPager(Context context) {
        super(context);
    }

    public UnSwipeableViewPager(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
