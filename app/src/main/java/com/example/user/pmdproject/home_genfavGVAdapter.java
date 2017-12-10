package com.example.user.pmdproject;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Windows10 on 09/12/2017.
 */

public class home_genfavGVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> comics;

    public home_genfavGVAdapter(Context mContext, ArrayList<Comix> comics) {
        this.mContext = mContext;
        this.comics = comics;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gv = inflater.inflate(R.layout.home_genfav_layout, viewGroup, false);
        ArrayList<Comix> comic = comics;
        ImageView image1 = (ImageView) gv.findViewById(R.id.image1);
        ImageView image2 = (ImageView) gv.findViewById(R.id.image2);
        ImageView image3 = (ImageView) gv.findViewById(R.id.image3);
        ImageView image4 = (ImageView) gv.findViewById(R.id.image4);
        ImageView image5 = (ImageView) gv.findViewById(R.id.image5);
        ImageView image6 = (ImageView) gv.findViewById(R.id.image6);

        image1.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(0).thumbnail));
        image2.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(1).thumbnail));
        image3.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(2).thumbnail));
        image4.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(3).thumbnail));
        image5.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(4).thumbnail));
        image6.setImageDrawable(MainActivity.getDrawableFromAssets(mContext, comic.get(5).thumbnail));
        return gv;
    }
}
