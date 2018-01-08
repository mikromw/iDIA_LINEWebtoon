package com.example.user.pmdproject.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.user.pmdproject.R;
import com.example.user.pmdproject.fragments.more.adapters.GenrePA;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        // Get view pager
        ViewPager genrevp = (ViewPager)findViewById(R.id.genrevp);
        // Get top tab layout navigation
        TabLayout genretabs = (TabLayout)findViewById(R.id.genretabs);
        // set adapter for the view pager
        genrevp.setAdapter(new GenrePA(getSupportFragmentManager()));
        // sync the tab with the view pager
        genretabs.setupWithViewPager(genrevp);
    }
}
