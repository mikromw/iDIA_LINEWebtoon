package com.example.user.pmdproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by User on 24/11/2017.
 */

public class ComicAdapter extends BaseAdapter {

    private final Context mContext;
    private final Comix[] comics;

    public ComicAdapter(Context context, Comix[] comics) {
        this.mContext = context;
        this.comics = comics;
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
        return null;
    }
}
