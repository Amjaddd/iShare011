package com.example.husam_pc.myishare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class FriendsFragmentTab extends Fragment implements View.OnClickListener    {
    TextView friendsCounterTxt;
    public static int fCounter;
    RecyclerView recyclerView;
    ArrayList<ModelContactsList> friendList;
    private int page;
    private  RelativeLayout add_contact,new_group;


    public FriendsFragmentTab() {
        // Required empty public constructor
    }

    public static FriendsFragmentTab newInstance() {

        FriendsFragmentTab friendsFragmentTab = new FriendsFragmentTab();

        return friendsFragmentTab;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_friends_tab, container, false);
        upData(rootView);
        friendsCounterTxt = rootView.findViewById(R.id.ContactsCounter);

        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new AdapterFriendsList(rootView.getContext(),friendList));

        friendsCounterTxt.setText(fCounter+"");

        add_contact = (RelativeLayout) rootView.findViewById(R.id.add_contact);
        new_group = (RelativeLayout) rootView.findViewById(R.id.new_group);

        add_contact.setOnClickListener(this);
        new_group.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_contact:
                Intent intent = new Intent(getActivity(), ActivityContactList.class);
                intent.putExtra("clicked", "add_contact");
                startActivity(intent);
                break;

            case R.id.new_group:
                intent = new Intent(getActivity(),ActivityContactList.class);
                intent.putExtra("clicked","new_group");
                startActivity(intent);
                break;
        }

    }

    private void upData(View rootView) {
        int[] userDPIconsList = {R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round};
        String[] userNameList = {"husam","amjad","zeev","Family","driver","trip"};
        String[] userStatusList = {"Online","Ofline","Online","Active","Inactive","Active"};
        String[] pNumList={"054217852","054788756","056488799"};
        List<String> pNList1 = new ArrayList<>();
        pNList1.add("054217852");
        pNList1.add("054788756");

        List<String> pNList2 = new ArrayList<>();
        pNList2.add("054217852");
        pNList2.add("054788756");
        pNList2.add("054128756");

        List<String> pNList3 = new ArrayList<>();
        pNList3.add("054217852");
        pNList3.add("054788756");
        pNList3.add("054217752");
        pNList3.add("054798756");


        friendList = new ArrayList<>();
        recyclerView= rootView.findViewById(R.id.friendsRV);


        FriendsFragmentTab.fCounter = userDPIconsList.length;

        for (int i=0;i<3;i++){
            ModelContactsList FL = new ModelContactsList(userDPIconsList[i],userNameList[i],userStatusList[i],pNumList[i]);
            friendList.add(FL);
        }
        ModelContactsList FL3 = new ModelContactsList(userDPIconsList[3],userNameList[3],userStatusList[3],pNList1);
        friendList.add(FL3);
        ModelContactsList FL4 = new ModelContactsList(userDPIconsList[4],userNameList[4],userStatusList[4],pNList2);
        friendList.add(FL4);
        ModelContactsList FL5 = new ModelContactsList(userDPIconsList[5],userNameList[5],userStatusList[5],pNList3);
        friendList.add(FL5);
    }


}
