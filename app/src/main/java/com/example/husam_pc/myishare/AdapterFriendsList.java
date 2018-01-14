package com.example.husam_pc.myishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by husam_pc on 23/12/2017.
 */

public class AdapterFriendsList extends RecyclerView.Adapter<AdapterFriendsList.friendsViewHolder> {

    Context context;
    private List<ModelContactsList> friendsLists;

    public AdapterFriendsList(Context context, List<ModelContactsList> list){
        this.context=context;
        friendsLists = list;
    }

    @Override
    public friendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.friends_list_view,parent,false);

        return new friendsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(friendsViewHolder holder,final int position) {

        holder.userIcon.setImageResource(friendsLists.get(position).getUserIconId());
        holder.userName.setText(friendsLists.get(position).getUserNameId());
        holder.userStatus.setText(friendsLists.get(position).getUserStatus());


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainChat.class);
                intent.putExtra("DPID",friendsLists.get(position).getUserIconId()+"");
                intent.putExtra("Name",friendsLists.get(position).getUserNameId()+"");
                intent.putExtra("Status",friendsLists.get(position).getUserStatus()+"");
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return friendsLists.size();
    }


    class friendsViewHolder extends RecyclerView.ViewHolder{

        ImageView userIcon;
        TextView userName;
        TextView userStatus;
        RelativeLayout relativeLayout;

        public friendsViewHolder(View itemView) {
            super(itemView);
            userIcon = itemView.findViewById(R.id.userDPIcon);
            userName = itemView.findViewById(R.id.userNameTxt);
            userStatus= itemView.findViewById(R.id.userStatusTxt);
            relativeLayout=itemView.findViewById(R.id.view);
        }
    }


}
