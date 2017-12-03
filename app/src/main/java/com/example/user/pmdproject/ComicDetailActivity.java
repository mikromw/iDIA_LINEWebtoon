package com.example.user.pmdproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ComicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        final Comix sample = this.getIntent().getParcelableExtra("comic");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        ArrayList<Chapters> sample = this.getIntent().getParcelableArrayListExtra("chapters");
//        Log.i("pjg", String.valueOf(sample.size()));
        ListView lv = (ListView)findViewById(R.id.chapters);
        lv.setAdapter(new ChaptersAdapter(this, sample.chapters));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Chapters selectedComic = sample.chapters.get(position);

                // 2
                Intent readIntent = new Intent(ComicDetailActivity.this, ReadEpisodeActivity.class);

                // 3
//                detailIntent.putParcelableArrayListExtra("chapters", selectedComic.chapters);
                readIntent.putExtra("chapters", selectedComic);

                // 4
                startActivity(readIntent);
            }

        });

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
