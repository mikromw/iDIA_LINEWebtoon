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
 * Created by Chris Shinta on 08/12/2017.
 */

public class home_favGVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> comics;

    public home_favGVAdapter(Context mContext, ArrayList<Comix> comics) {
        this.mContext = mContext;
        this.comics = comics;
    }

    @Override
    public int getCount() {
        return 3;
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
        View gv;
        if(view == null) {
            gv = new View(mContext);
            gv = inflater.inflate(R.layout.home_fav_layout, viewGroup, false);
        }
        else {
            gv = (View)view;
        }
        final ImageView icon = (ImageView)gv.findViewById(R.id.comic_icon);
        final TextView title = (TextView)gv.findViewById(R.id.comic_title);
        final ButtonBarLayout fav = (ButtonBarLayout)gv.findViewById(R.id.comic_fav);
        icon.setImageBitmap(MainActivity.getBitmapFromAssets(mContext, comic.thumbnail));
        title.setText(comic.title);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Favorit tidak aktif", Toast.LENGTH_SHORT).show();
            }
        });

        return gv;
    }
}
