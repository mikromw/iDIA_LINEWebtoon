package com.example.user.pmdproject;

import android.content.Context;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Windows 10 on 09/12/2017.
 */

public class home_newGVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> comics;

    public home_newGVAdapter(Context mContext, ArrayList<Comix> comics) {
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
        final Comix comic = comics.get(i);
        View gv = inflater.inflate(R.layout.home_new_layout, viewGroup, false);
        ImageView iv = (ImageView) gv.findViewById(R.id.image_cover);
        iv.setImageBitmap(MainActivity.getBitmapFromAssets(mContext, comic.thumbnail));
        return gv;
    }
}
