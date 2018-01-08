package com.example.user.pmdproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GridDailyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GridDailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridDailyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public ArrayList<Comix> collection;
    public GridDailyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridDailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GridDailyFragment newInstance() {
        GridDailyFragment fragment = new GridDailyFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", MainActivity.comics);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            collection = getArguments().getParcelableArrayList("data");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Context context = getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.fragment_grid_view, container, false);

        GridView gv = (GridView)rootView.findViewById(R.id.test_grid);
        gv.setAdapter(new home_todayGVAdapter(context, collection));


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Comix selectedComic = collection.get(position);

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
