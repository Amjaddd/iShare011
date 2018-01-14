package com.example.husam_pc.myishare;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by husam_pc on 24/12/2017.
 */

public class AdapterChatsList extends RecyclerView.Adapter<AdapterChatsList.friendsViewHolder>{
    Context context;
    private List<ModelChatsList> chatsList;

    public AdapterChatsList(Context context, List<ModelChatsList> chatsList) {
        this.context = context;
        this.chatsList = chatsList;
    }

    @Override
    public friendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.chats_list_view,parent,false);
        return new friendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterChatsList.friendsViewHolder holder, int position) {
        if(!chatsList.get(position).getUserSend().equals("")){
            holder.userName.setText(chatsList.get(position).getUserSend());
        }else{
            holder.userName.setText("");
            holder.cardView.setBackgroundColor(Color.rgb(89,166,225));
            //CardView.LayoutParams layoutParams=new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT);
            // layoutParams.setMargins(70,25,25,25);
            // holder.cardView.setLayoutParams(layoutParams);
        }

        holder.userMessage.setText(chatsList.get(position).getMessage());
        holder.timeMessage.setText(chatsList.get(position).getTimeMessage());


    }

    @Override
    public int getItemCount() {
        return chatsList.size();
    }

    class friendsViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView userMessage;
        TextView timeMessage;
        CardView cardView;

        public friendsViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.txtVFriend);
            userMessage = itemView.findViewById(R.id.txtVChat);
            timeMessage=itemView.findViewById(R.id.txtVTime);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }

}
