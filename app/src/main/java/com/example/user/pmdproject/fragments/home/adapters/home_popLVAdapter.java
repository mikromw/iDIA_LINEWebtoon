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
 * Created by Chris Shinta on 10/12/2017.
 */

public class home_popLVAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Comix> popular;

    public home_popLVAdapter(Context mContext, ArrayList<Comix> popular) {
        this.mContext = mContext;
        this.popular = popular;
    }

    @Override
    public int getCount() {
        return 5;
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
        final Comix comic = popular.get(i);
        View lv = inflater.inflate(R.layout.home_poplv_layout, viewGroup, false);

        final ImageView icon = (ImageView) lv.findViewById(R.id.pop_image);
        final TextView title = (TextView) lv.findViewById(R.id.pop_title);
        final TextView genre = (TextView) lv.findViewById(R.id.pop_genre);
        final TextView sn = (TextView) lv.findViewById(R.id.pop_sn);

        icon.setImageBitmap(MainActivity.getBitmapFromAssets(mContext, comic.thumbnail));
        sn.setText(""+(i+1));
        title.setText(comic.title);
        genre.setText(comic.genre.getName());
        genre.setTextColor(comic.genre.getColor());

        return lv;
    }
}
