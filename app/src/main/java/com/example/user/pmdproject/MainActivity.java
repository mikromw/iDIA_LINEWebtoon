package com.example.user.pmdproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    public static String[] colorNavs = new String[] {"#00D22C", "#ED5F5E", "#F5A622", "#2B96DA", "#00D22C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setTextSize(10);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.mainvp);
        final Nav_PA pagerAdapter = new Nav_PA(getSupportFragmentManager(), bnve.getItemCount());

        viewPager.setAdapter(pagerAdapter);
        bnve.setupWithViewPager(viewPager);


        for(int i=0; i < bnve.getItemCount(); i++) {
            bnve.setTextTintList(i, new ColorStateList(
                    new int[][] {
                            new int[] {android.R.attr.state_checked},
                            new int[] {android.R.attr.state_pressed},
                            new int[] {android.R.attr.state_selected},
                            new int[] {-android.R.attr.state_selected}
                    },
                    new int[] {
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.parseColor(colorNavs[i]),
                            Color.BLACK
                    })
            );
        }

    }
}
