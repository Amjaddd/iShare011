package com.example.husam_pc.myishare;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by husam_pc on 23/12/2017.
 */

public class FragmentChatsList extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ModelChatsList> chatsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.recycler_chats_list,container,false);

        String[] users={"husam","amjad","zeev",""};
        String[] message={"hello friends h r y?","fine,I'm going to Tel Aviv","I'm usual at work","I'm usual at work","I'm in the Caribbean"};

        chatsList=new ArrayList<>();
        recyclerView=rootView.findViewById(R.id.chatsRV);
        for(int i=0;i<4;i+=1)
        {
            ModelChatsList Fl=new ModelChatsList(users[i],message[i]);
            chatsList.add(Fl);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new AdapterChatsList(rootView.getContext(),chatsList));

        return rootView;

    }
}
