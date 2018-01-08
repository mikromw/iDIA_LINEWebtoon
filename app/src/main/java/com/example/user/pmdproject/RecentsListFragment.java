package com.example.user.pmdproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by User on 01/12/2017.
 */

public class RecentsListFragment extends Fragment {
    public FavComicAdapter adapter;
    public RecentsListFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity().getApplicationContext();
        adapter = new FavComicAdapter(context, MainActivity.favorites);
        View rootView = inflater.inflate(R.layout.recentslist, container, false);

        ListView lv = (ListView)rootView.findViewById(R.id.fav_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Chapters selectedChapter = MainActivity.favorites.get(position).checkpoint;

                // 2
                Intent readIntent = new Intent(context, ReadEpisodeActivity.class);

                // 3
//                detailIntent.putParcelableArrayListExtra("chapters", selectedComic.chapters);
                readIntent.putExtra("chapters", selectedChapter);

                // 4
                startActivity(readIntent);
            }

        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
