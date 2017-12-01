package com.example.user.pmdproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by User on 01/12/2017.
 */

public class Saturday_Fragment extends Fragment {
    public Saturday_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.saturday, container, false);

        GridView gv = (GridView) rootView.findViewById(R.id.daily_grid);
        gv.setAdapter(new ComicAdapter(getActivity().getApplicationContext(), MainActivity.comics));

        return rootView;
    }
}
