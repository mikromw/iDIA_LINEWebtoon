package com.example.user.pmdproject.classes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by User on 26/11/2017.
 */

public class GridImageView extends ImageView {

    public GridImageView(Context context) {
        super(context);
    }

    public GridImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public GridImageView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
