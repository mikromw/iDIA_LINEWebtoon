package com.example.user.pmdproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by User on 01/12/2017.
 */

public class RecentsListFragment extends Fragment {
    public RecentsListFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final Context context = getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.recentslist, container, false);

        ListView lv = (ListView)rootView.findViewById(R.id.fav_list);
        lv.setAdapter(new FavComicAdapter(context, MainActivity.comics));


//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // 1
//                Comix selectedComic = MainActivity.comics.get(position);
//
//                // 2
//                Intent detailIntent = new Intent(context, RecipeDetailActivity.class);
//
//                // 3
//                detailIntent.putExtra("title", selectedRecipe.title);
//                detailIntent.putExtra("url", selectedRecipe.instructionUrl);
//
//                // 4
//                startActivity(detailIntent);
//            }
//
//        });
        return rootView;
    }
}
