package com.example.user.pmdproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int current_page = 5000;
    public static ViewPager vp;
    public static HomeCarouselAdapter hcAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Home_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
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
        final Context context = getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.fragment_home_, container, false);

        // Carousel
        vp = (ViewPager) rootView.findViewById(R.id.home_carousel);
        hcAdapter = new HomeCarouselAdapter(getChildFragmentManager(), getContext(), container);
        vp.setAdapter(hcAdapter);
        vp.setCurrentItem(5000);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                current_page = position;
                MainActivity.stopTimer();
                MainActivity.startTimer();
            }
            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        // Favoritku
        GridView gv = (GridView) rootView.findViewById(R.id.home_gv_fav);
        gv.setAdapter(new home_favGVAdapter(context, MainActivity.comics));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comix selectedComic = MainActivity.comics.get(position);
                Intent detailIntent = new Intent(context, ComicDetailActivity.class);
                detailIntent.putExtra("comic", selectedComic);
                startActivity(detailIntent);
            }
        });

        // Baru dirilis
        LinearLayout ll_new= (LinearLayout) rootView.findViewById(R.id.home_ll_new);
        //new2_img.setImageBitmap(MainActivity.getBitmapsFromSubFolder(context, "home/new/new2.png"));
        Picasso mPicasso = Picasso.with(context);
        for(int i=1; i <= 2; i++) {
            ImageView img = new ImageView(context);
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setAdjustViewBounds(true);
            mPicasso.load("file:///android_asset/home/new/new" + i+".png")
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(img);
            ll_new.addView(img);
        }


        // Webtoon hari ini
        CustomGridView gv_today = (CustomGridView) rootView.findViewById(R.id.home_gv_today);
        gv_today.setAdapter(new home_todayGVAdapter(context, MainActivity.comics));

        gv_today.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comix selectedComic = MainActivity.comics.get(position);
                Intent detailIntent = new Intent(context, ComicDetailActivity.class);
                detailIntent.putExtra("comic", selectedComic);
                startActivity(detailIntent);
            }
        });

        // Genre favoritku
        CustomGridView gv_genfav = (CustomGridView) rootView.findViewById(R.id.home_gv_genfav);
        gv_genfav.setAdapter(new home_genfavGVAdapter(context, MainActivity.comics));

        gv_genfav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comix selectedComic = MainActivity.comics.get(position);
                Intent detailIntent = new Intent(context, ComicDetailActivity.class);
                detailIntent.putExtra("comic", selectedComic);
                startActivity(detailIntent);
            }
        });


        // Populer
        ListView lv_pop = (ListView) rootView.findViewById(R.id.home_lv_pop);
        lv_pop.setAdapter(new home_popLVAdapter(context, MainActivity.comics));

        lv_pop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comix selectedComic = MainActivity.comics.get(position);
                Intent detailIntent = new Intent(context, ComicDetailActivity.class);
                detailIntent.putExtra("comic", selectedComic);
                startActivity(detailIntent);
            }
        });
        // Mulai terbitkan komik karyamu sendiri

        // footer

        return rootView;
    }

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
