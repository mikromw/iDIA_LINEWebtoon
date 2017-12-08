package com.example.user.pmdproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.author;
import static android.media.CamcorderProfile.get;

/**
 * Created by User on 02/12/2017.
 */

public class ChaptersAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Chapters> chapters;

    public ChaptersAdapter(Context context, ArrayList<Chapters> chaps) {
        this.mContext = context;
        this.chapters = chaps;
    }

    @Override
    public int getCount() {
        return chapters.size();
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
        final Chapters chap = chapters.get(i);
        View lv = inflater.inflate(R.layout.chapterslist, viewGroup, false);

        lv.setBackgroundColor(0xEEFFFFFF);
        final ImageView icon = (ImageView) lv.findViewById(R.id.chapter_icon);
        final TextView title = (TextView) lv.findViewById(R.id.chapter_title);
        final TextView release_date = (TextView) lv.findViewById(R.id.chapter_date);

        Bitmap bm = MainActivity.getBitmapFromAssets(mContext, chap.coverImg);
        icon.setImageBitmap(bm);
        title.setText(chap.getChapterTitle());
        release_date.setText(chap.getChapterDate());

        return lv;
    }
}