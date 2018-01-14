package com.example.husam_pc.myishare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


public class FragmentProfile extends Fragment {


    EditText edUserName,edPhoneNum,edAbout;
    ImageView imgProfile;
    public FragmentProfile() {
        // Required empty public constructor
    }

    public static FragmentProfile newInstance() {

        FragmentProfile fragment = new FragmentProfile();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootVeiw=inflater.inflate(R.layout.fragment_profile, container, false);
        edPhoneNum=rootVeiw.findViewById(R.id.edPoneNum);
        edAbout=rootVeiw.findViewById(R.id.edAbout);
        edUserName=rootVeiw.findViewById(R.id.edUserName);
        imgProfile=rootVeiw.findViewById(R.id.imageProfile);
        imgProfile.setImageResource(R.mipmap.myprofile);


        return rootVeiw;
    }






}
