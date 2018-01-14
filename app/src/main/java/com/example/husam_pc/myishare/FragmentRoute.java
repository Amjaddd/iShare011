package com.example.husam_pc.myishare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentRoute extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ModelRouteList> routesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.recycler_route_list, container, false);
        upData(rootView);
        Log.d("recycler data", "onCreateView: ");
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new AdapterRoutesList(rootView.getContext(),routesList));
        Log.d("recycler", "onCreateView: ");

        return rootView;
    }

    private void upData(View rootView) {
        int[] routesIdList={R.mipmap.map1,R.mipmap.map2,R.mipmap.map3};
        String[]userList={"husam","amjad","zeev"};

        routesList=new ArrayList<>();
        recyclerView=rootView.findViewById(R.id.routesRV);

        for(int i=0;i<routesIdList.length;i+=1){
            ModelRouteList rL=new ModelRouteList(userList[i],routesIdList[i]);
            routesList.add(rL);
        }


    }


}
