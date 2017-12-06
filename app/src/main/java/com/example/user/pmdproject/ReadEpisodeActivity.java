package com.example.user.pmdproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReadEpisodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_episode);

        final Chapters sample = this.getIntent().getParcelableExtra("chapters");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(sample.getChapterTitle());
        }

//        ArrayList<Chapters> sample = this.getIntent().getParcelableArrayListExtra("chapters");

//        Log.i("pjg", String.valueOf(sample.size()));
        LinearLayout ll = (LinearLayout)findViewById(R.id.eps_preview);

        String[] imgFiles = MainActivity.getBitmapsFromSubFolder(this, sample.chapterDirs);

        Picasso mPicasso = Picasso.with(this);

        mPicasso.setIndicatorsEnabled(true);

        for(int i=0; i < imgFiles.length; i++) {
            Log.i("pjg", String.valueOf(imgFiles[i]));
        }
//        Log.i("pjg", String.valueOf(thumbs.size()));
        for(int i=0; i < imgFiles.length; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setAdjustViewBounds(true);
            mPicasso.load("file:///android_asset/" + sample.chapterDirs + "/" + imgFiles[i])
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(img);

            ll.addView(img);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
