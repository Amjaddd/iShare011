package com.example.husam_pc.myishare;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by husam_pc on 23/12/2017.
 */

public class IsharedPreference {
    private SharedPreferences sharedPreferences;
    private static final String Pass = "passwordKey";
    private static final String Name = "nameKey";
    private static final String Gps="gpsKey";
    private static final String Camera = "cameraKey";
    private static final String Mic="micKey";



    public void openShared(String userName, String userEmail, String userPass, Context context) {

        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Pass,userPass);
        editor.putString(Name,userName);
        editor.putBoolean(Gps,false);
        editor.putBoolean(Camera,false);
        editor.putBoolean(Mic,false);

        editor.apply();
    }

    public void gpsOn(String userEmail,Context context){
        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Gps,true);

        editor.apply();

    }

    public void micOn(String userEmail,Context context){
        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Mic,true);

        editor.apply();
    }

    public void cameraOn(String userEmail,Context context){
        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Camera,true);

        editor.apply();
    }

    public boolean chekUserExists(String userEmail,Context context){

        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);

        String name=sharedPreferences.getString(Name,"na");

        return !name.equals("na");
    }

    public boolean chekLogin(String userEmail,String userPass,Context context){
        sharedPreferences=context.getSharedPreferences(userEmail,Context.MODE_PRIVATE);

        String sPass=sharedPreferences.getString(Pass,"na");

        return userPass.equals(sPass);
    }
}
