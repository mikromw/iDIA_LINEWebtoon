package com.example.user.pmdproject.classes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Chris Shinta on 10/12/2017.
 */

public class CustomListView_nonScrollable extends ListView {
    public CustomListView_nonScrollable(Context context) {
        super(context);
    }
        public CustomListView_nonScrollable(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
        public CustomListView_nonScrollable(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
        }
}
