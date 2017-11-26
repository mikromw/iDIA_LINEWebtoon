package com.example.user.pmdproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by User on 26/11/2017.
 */

public class Monday_Fragment extends Fragment {
    public Monday_Fragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.monday, container, false);

        GridView gv = (GridView)rootView.findViewById(R.id.daily_grid);
        gv.setAdapter(new ComicAdapter(getActivity().getApplicationContext(), MainActivity.comics));

        return rootView;
    }
}
