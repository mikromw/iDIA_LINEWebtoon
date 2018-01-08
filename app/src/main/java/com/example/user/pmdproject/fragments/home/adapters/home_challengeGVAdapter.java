package com.example.user.pmdproject.fragments.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.pmdproject.MainActivity;
import com.example.user.pmdproject.R;
import com.example.user.pmdproject.models.Comix;

import java.util.ArrayList;

/**
 * Created by Chris Shinta on 11/12/2017.
 */

public class home_challengeGVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> comics;

    public home_challengeGVAdapter(Context mContext) {
        this.mContext = mContext;
        comics = new ArrayList<Comix>();
        comics.add(new Comix("WARUNG", "Yupit", "", "home/challenge/challenge1.png", Comix.Genre.COMEDY, 76271));
        comics.add(new Comix("Dreamscape", "Budi Setiawan", "", "home/challenge/challenge2.png", Comix.Genre.FANTASY, 76271));
        comics.add(new Comix("X SCHOOL", "aans", "", "home/challenge/challenge3.png", Comix.Genre.DRAMA, 76271));
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
            gv = inflater.inflate(R.layout.home_challenge_layout, viewGroup, false);
        }
        else {
            gv = (View)view;
        }
        final ImageView icon = (ImageView)gv.findViewById(R.id.comic_icon);
        final TextView title = (TextView)gv.findViewById(R.id.comic_title);
        final TextView author = (TextView)gv.findViewById(R.id.comic_author);
        icon.setImageBitmap(MainActivity.getBitmapPublicFromAssets(mContext, comic.thumbnail));
        title.setText(comic.title);
        author.setText(comic.author);

        return gv;
    }
}
