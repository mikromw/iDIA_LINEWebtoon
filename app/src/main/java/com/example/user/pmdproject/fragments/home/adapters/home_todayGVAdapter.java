package com.example.user.pmdproject.fragments.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.pmdproject.R;
import com.example.user.pmdproject.activities.MainActivity;
import com.example.user.pmdproject.models.Comix;

import java.util.ArrayList;

/**
 * Created by Windows10 on 09/12/2017.
 */

public class home_todayGVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> comics;

    public home_todayGVAdapter(Context mContext, ArrayList<Comix> comics) {
        this.mContext = mContext;
        this.comics = comics;
    }

    @Override
    public int getCount() {
        return 6;
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
            gv = inflater.inflate(R.layout.home_today_layout, viewGroup, false);
        }
        else {
            gv = (View)view;
        }
        final ImageView icon = (ImageView)gv.findViewById(R.id.comic_icon);
        final TextView title = (TextView)gv.findViewById(R.id.comic_title);
        final TextView genre = (TextView)gv.findViewById(R.id.comic_genre);
        final TextView like = (TextView)gv.findViewById(R.id.comic_likes);
        icon.setImageBitmap(MainActivity.getBitmapFromAssets(mContext, comic.thumbnail));
        title.setText(comic.title);
        genre.setText(comic.genre.getName());
        genre.setTextColor(comic.genre.getColor());
        like.setText(String.valueOf(comic.likes));
        return gv;
    }
}
