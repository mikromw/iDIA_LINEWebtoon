package com.example.user.pmdproject.classes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by User on 01/12/2017.
 */

public class ListImageView extends ImageView {

    public ListImageView(Context context) {
        super(context);
    }

    public ListImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public ListImageView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
    }
}
