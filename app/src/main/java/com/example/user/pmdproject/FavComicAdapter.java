package com.example.user.pmdproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.user.pmdproject.MainActivity.comics;

/**
 * Created by User on 01/12/2017.
 */

public class FavComicAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Comix> favs;

    public FavComicAdapter(Context context, ArrayList<Comix> favs) {
        this.mContext = context;
        this.favs = favs;
    }

    @Override
    public int getCount() {
        return favs.size();
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
        final Comix comic = favs.get(i);
        View lv = inflater.inflate(R.layout.fav_layout, viewGroup, false);

        final ImageView icon = (ImageView) lv.findViewById(R.id.comic_icon);
        final TextView title = (TextView) lv.findViewById(R.id.comic_title);
        final TextView author = (TextView) lv.findViewById(R.id.comic_author);

        icon.setImageBitmap(MainActivity.getBitmapFromAssets(mContext, comic.thumbnail));
        title.setText(comic.title);
        author.setText(comic.author);

        return lv;
    }
}
