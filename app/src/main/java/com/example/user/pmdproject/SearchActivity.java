package com.example.user.pmdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.user.pmdproject.R;
import com.example.user.pmdproject.fragments.fav.adapters.FavComicAdapter;
import com.example.user.pmdproject.models.Comix;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Comix> searchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchList = new ArrayList<Comix>();

        final EditText searchTxt = (EditText)findViewById(R.id.searchTxt);
        final Button cancelBtn = (Button)findViewById(R.id.cancelBtn);
        final FavComicAdapter adapter = new FavComicAdapter(this, searchList);
        final ListView searchResults = (ListView)findViewById(R.id.searchResults);

        searchTxt.requestFocus();
        searchResults.setAdapter(adapter);
        searchTxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchQuery = searchTxt.getText().toString();
                int textLength = searchQuery.length();
                searchList.clear();

                for(int j=0; j < MainActivity.comics.size(); j++) {
                    Comix itemAtThisIndex = MainActivity.comics.get(j);
                    if(!searchQuery.trim().isEmpty() && (itemAtThisIndex.author.toLowerCase().contains(searchQuery.toLowerCase()) || itemAtThisIndex.title.toLowerCase().contains(searchQuery.toLowerCase()))) {
                        searchList.add(itemAtThisIndex);
                    }
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        searchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Comix selectedComic = searchList.get(i);

                Intent detailIntent = new Intent(SearchActivity.this, ComicDetailActivity.class);

                detailIntent.putExtra("comic", selectedComic);

                startActivity(detailIntent);
            }
        });
    }
    public void initList() {

    }
}
