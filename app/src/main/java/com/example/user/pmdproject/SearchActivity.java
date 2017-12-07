package com.example.user.pmdproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Comix> searchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchList = new ArrayList<Comix>();

        final EditText searchTxt = (EditText)findViewById(R.id.searchTxt);
        searchTxt.requestFocus();

        final ListView searchResults = (ListView)findViewById(R.id.searchResults);

        searchTxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                FavComicAdapter adapter = null;
                String searchQuery = searchTxt.getText().toString();
                int textLength = searchQuery.length();
                searchList.clear();

                for(int j=0; j < MainActivity.comics.size(); j++) {
                    Comix itemAtThisIndex = MainActivity.comics.get(j);
                    if(itemAtThisIndex.author.toLowerCase().contains(searchQuery.toLowerCase()) || itemAtThisIndex.title.toLowerCase().contains(searchQuery.toLowerCase())) {
                        searchList.add(itemAtThisIndex);
                        adapter = new FavComicAdapter(SearchActivity.this, searchList);
                        searchResults.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
