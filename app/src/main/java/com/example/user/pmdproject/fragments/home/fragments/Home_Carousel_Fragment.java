package com.example.user.pmdproject.fragments.home.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.pmdproject.MainActivity;
import com.example.user.pmdproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Carousel_Fragment extends Fragment {
    private final String[] paths = {"cover/Blessed.jpg", "cover/Adventures of God.jpg", "cover/unOrdinary.jpg", "cover/Eggnoid.jpg", "cover/Small World.jpg", "cover/Melvina's Therapy.jpg"};
    public int position;

    public static Home_Carousel_Fragment newInstance(int position){
        Home_Carousel_Fragment hcf = new Home_Carousel_Fragment();
        hcf.position = position;
        return hcf;
    }

    public Home_Carousel_Fragment(){ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_carousel, container, false);
        ImageView iv = (ImageView) v.findViewById(R.id.carousel_image);
        Drawable d = MainActivity.getDrawableFromAssets(getContext(), paths[position]);
        iv.setImageDrawable(d);
        return v;
    }


}
