package com.example.user.pmdproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import static android.media.CamcorderProfile.get;

/**
 * Created by User on 26/11/2017.
 */

public class Monday_Fragment extends Fragment {
    public Monday_Fragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.monday, container, false);

        GridView gv = (GridView)rootView.findViewById(R.id.daily_grid);
        gv.setAdapter(new ComicAdapter(context, MainActivity.comics));


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Comix selectedComic = MainActivity.comics.get(position);

                // 2
                Intent detailIntent = new Intent(context, ComicDetailActivity.class);

                // 3
//                detailIntent.putParcelableArrayListExtra("chapters", selectedComic.chapters);
                detailIntent.putExtra("comic", selectedComic);

                // 4
                startActivity(detailIntent);
            }

        });
        return rootView;
    }
}
