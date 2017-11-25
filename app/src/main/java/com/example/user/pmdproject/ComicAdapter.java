package com.example.user.pmdproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 24/11/2017.
 */

public class ComicAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Comix> comics;

    public ComicAdapter(Context context, ArrayList<Comix> comics) {
        this.mContext = context;
        this.comics = comics;
    }

    @Override
    public int getCount() {
        return comics.size();
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
            gv = inflater.inflate(R.layout.linearlayout_comic, viewGroup, false);
        }
        else {
            gv = (View)view;
        }

        Log.i("pjg", String.valueOf(gv));
//        final ImageView icon = (ImageView)view.findViewById(R.id.comic_icon);
        final TextView title = (TextView)view.findViewById(R.id.comic_title);
        final TextView genre = (TextView)view.findViewById(R.id.comic_genre);

        title.setText(String.valueOf(i));
//        icon.setImageResource(comic.imgs);
//        title.setText(comic.title);
        genre.setText(comic.genre.toString().replaceAll("_", " "));

        return gv;
    }
}
