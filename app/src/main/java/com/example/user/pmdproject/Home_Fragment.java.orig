package com.example.user.pmdproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


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
        final ScrollView sv = rootView.findViewById(R.id.home_sv);
        //Search
        ImageButton search_btn = rootView.findViewById(R.id.home_search);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(getActivity().getApplicationContext(), SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        // Carousel
        CarouselView carouselView = rootView.findViewById(R.id.carouselView);
        ArrayList<Comix> comics = MainActivity.comics;
        final Drawable[] sampleImages = {
                MainActivity.getDrawablePublicFromAssets(getContext(), "home/slide/slide1.jpg"),
                MainActivity.getDrawablePublicFromAssets(getContext(), "home/slide/slide2.jpg"),
                MainActivity.getDrawablePublicFromAssets(getContext(), "home/slide/slide3.jpg"),
                MainActivity.getDrawablePublicFromAssets(getContext(), "home/slide/slide4.jpg"),
                MainActivity.getDrawablePublicFromAssets(getContext(), "home/slide/slide5.jpg")
        };

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageDrawable(sampleImages[position]);
            }
        };

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

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
        GridView gv_challenge = (GridView) rootView.findViewById(R.id.home_gv_challenge);
        gv_challenge.setAdapter(new home_challengeGVAdapter(context));

        gv_challenge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Challenge tidak aktif", Toast.LENGTH_SHORT).show();
            }
        });
        // footer
        LinearLayout ll_top = rootView.findViewById(R.id.home_to_top);

        ll_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.fullScroll(ScrollView.FOCUS_UP);
            }
        });
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
