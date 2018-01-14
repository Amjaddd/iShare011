package com.example.husam_pc.myishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by husam_pc on 05/01/2018.
 */

public class AdapterRoutesList extends RecyclerView.Adapter<AdapterRoutesList.routesViewHolder>  {

    Context context;
    private List<ModelRouteList> routesList;

    public AdapterRoutesList(Context context, List<ModelRouteList> routesList) {
        this.context = context;
        this.routesList = routesList;
    }

    @Override
    public routesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.route_list_view,parent,false);
        Log.d("route list", "onCreateView: ");
        return new routesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(routesViewHolder holder, final int position) {
        holder.radioButton.setText(routesList.get(position).getUserName());
        Log.d("route data", "onCreateView: ");
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater=LayoutInflater.from(v.getContext());
                View view=layoutInflater.inflate(R.layout.click_route, (ViewGroup) v,false);

                ImageView imageView=view.findViewById(R.id.imgRoute);
                imageView.setImageResource(routesList.get(position).getRouteId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return routesList.size();
    }


    class routesViewHolder extends RecyclerView.ViewHolder{
        RadioButton radioButton;
        RelativeLayout relativeLayout;

        public routesViewHolder(View itemView) {
            super(itemView);
            radioButton=itemView.findViewById(R.id.radioButton);
            relativeLayout=itemView.findViewById(R.id.layoutRoute);
        }
    }
}
