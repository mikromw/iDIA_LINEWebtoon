package com.example.user.pmdproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Daily_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Daily_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Daily_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ArrayList<Comix> comics;

    private OnFragmentInteractionListener mListener;

    public Daily_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Daily_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Daily_Fragment newInstance(String param1, String param2) {
        Daily_Fragment fragment = new Daily_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_daily_, container, false);
        View days = getLayoutInflater().inflate(R.layout.monday, null);

        final GridView gridView = (GridView)days.findViewById(R.id.daily_grid);
        ComicAdapter booksAdapter = new ComicAdapter(getActivity(), MainActivity.comics);
        Log.i("pjg", String.valueOf(booksAdapter.getCount()));
        Log.i("pjg", String.valueOf(booksAdapter.getItem(0)));
        gridView.setAdapter(booksAdapter);
        Log.i("pjg", String.valueOf(gridView.getAdapter().isEmpty()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "Something", Toast.LENGTH_SHORT).show();
            }
        });

        // Get view pager
        ViewPager dailyvp = (ViewPager)ret.findViewById(R.id.dailyvp);
        // Get top tab layout navigation
        TabLayout dailytabs = (TabLayout)ret.findViewById(R.id.dailytabs);
        // set adapter for the view pager
        dailyvp.setAdapter(new Custom_VPA(this.getContext()));
        // sync the tab with the view pager
        dailytabs.setupWithViewPager(dailyvp);
        // done and return the view

        return ret;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
