package com.example.user.pmdproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 12/12/2017.
 */

public class LoadPagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String chapterDirs;
    private String[] imgFiles;
    private Context mContext;

    public LoadPagesAdapter() {}
    public void setArray(String chapterDirs, String[] imgFiles) {
        this.chapterDirs = chapterDirs;
        this.imgFiles = imgFiles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_pages, parent, false);
        this.mContext = parent.getContext();
        return new EpisodePagesVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EpisodePagesVH _epsVH = (EpisodePagesVH) holder;
        final String indexAddr = this.imgFiles[position];

        Picasso.with(mContext)
                .load("file:///android_asset/" + chapterDirs + "/" + indexAddr)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(_epsVH.thumbs);
    }

    private class EpisodePagesVH extends RecyclerView.ViewHolder {
        private ImageView thumbs;

        public EpisodePagesVH(View view) {
            super(view);
            thumbs = (ImageView)view.findViewById(R.id.comic_pages);
        }
    }
    @Override
    public int getItemCount() {
        return this.imgFiles.length;
    }
}
