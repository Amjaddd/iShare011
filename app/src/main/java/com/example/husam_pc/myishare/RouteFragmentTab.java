package com.example.husam_pc.myishare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RouteFragmentTab extends Fragment {



    public RouteFragmentTab() {
        // Required empty public constructor
    }


    public static RouteFragmentTab newInstance(){
        RouteFragmentTab fragment = new RouteFragmentTab();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_rout_tab, container, false);


        return rootView;
    }





}
