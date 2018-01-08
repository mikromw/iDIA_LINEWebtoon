package com.example.user.pmdproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView rv;
    private LoadPagesAdapter loadPagesAdapter;

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
        rv = (RecyclerView)findViewById(R.id.pages_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        String[] imgFiles = MainActivity.getBitmapsFromSubFolder(this, sample.chapterDirs);

        loadPagesAdapter = new LoadPagesAdapter();

        /*setting user rv adapter: inject data to adapter*/
        loadPagesAdapter.setArray(sample.chapterDirs, imgFiles);

        rv.setAdapter(loadPagesAdapter);

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
