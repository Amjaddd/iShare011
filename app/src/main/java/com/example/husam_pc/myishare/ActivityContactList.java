package com.example.husam_pc.myishare;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * Created by arabi_000 on 1/9/2018.
 */

public class ActivityContactList extends AppCompatActivity {


    private ArrayAdapter<String> arrayAdapter;
    private Cursor cursor;
    private String name, phonenumber, img;
    public static final int CONTACTS_PERM = 2;
    private Button doneButton;
    private ArrayList<ModelContactsList> contactsList;
    private ArrayList<ModelContactsList> groupList;
    private ArrayList<ModelContactsList> inviteList;
    private static final int REQUEST_INVITE = 8001;
    private String value = "";
    private int page;
    private RecyclerView recyclerView;
    private RelativeLayout invite_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        checkPerm(); // method to check Contact permission

//        inviteClick(); // method to set invite button with on click method
    }

   /* private void inviteClick() { // method for invite button
        invite_btn = findViewById(R.id.invite_btn);
        GetContactsIntoArrayList();

        invite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter = new ArrayAdapter<String>(ActivityContactList.this, R.layout.view_all_contact_invite,
                        0,inviteList);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        try {
                            String itemValue = (String) listView.getItemAtPosition(position);

                            // intent to invite the contact who do not have the application
                            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                            sendIntent.putExtra("sms_body", "Hello i using iShare download link : https://google.play.com"); // box msg
                            sendIntent.setType("vnd.android-dir/mms-sms");
                            if (itemValue != null) {
                                sendIntent.putExtra("address", itemValue);
                            } else {
                                Toast.makeText(ActivityContactList.this, "Unknow Erorr", Toast.LENGTH_SHORT).show();
                            }
                            startActivity(sendIntent);

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }*/

    private void checkPerm() {
        // Check if we already have permission
        int contactPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        // If we do not have permission
        if (contactPerm != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActivityContactList.this, new String[]{Manifest.permission.READ_CONTACTS}, 2);
        } else {
            // if we Already have Permission
            setPointer();
        }
    }

    private void setPointer() {
        recyclerView = findViewById(R.id.listView);
        doneButton = findViewById(R.id.doneGroupChatBtn);
        contactsList=new ArrayList<>();
        groupList=new ArrayList<>();
        inviteList=new ArrayList<>();


       //GetContactsIntoArrayList(); // Method to get contact with cursor for invite


// intent to check if one contact or more than one contact
        final Intent intent = getIntent();
        if (intent != null)
            value = intent.getStringExtra("clicked");
        switch (value) {
            case "add_contact":


               doneButton.setVisibility(View.INVISIBLE);
                int[] userDPIconsList = {R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round};
                String[] userNameList = {"Husam Bariyah","Amjad Arabiya","Zeev Mindale"};
                String[] userStatusList = {"Online","Ofline","Online"};
                String[] pNumList={"054217852","054788756","056488799"};
                for(int i=0;i<userNameList.length;i+=1){
                    ModelContactsList md=new ModelContactsList(userDPIconsList[i],userNameList[i],userStatusList[i],pNumList[i]);
                    contactsList.add(md);
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new AdapterShowContacts(this,contactsList));

                break;
            
           /* case "new_group":
                    doneButton.setVisibility(View.VISIBLE); //visible doneButton for group select
                //Adapter for group contacts
                AdapterShowGroupContacts adapterShowGroupsContacts = new AdapterShowGroupContacts(ActivityContactList.this,contactsList);
                listView.setAdapter(adapterShowGroupsContacts);

                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Add code here to open alert dialog only when more than one contact is checked v

                        final AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                        alert.setTitle("iShare");
                        alert.show();
                    }
                });

                break;*/
        }

    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case CONTACTS_PERM:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    setPointer(); // if the user allow the permission run setPointer method

                } else {

                    //  Toast.makeText(this, "Permission Canceled", Toast.LENGTH_LONG).show();

                    // if the user canceled the permission run alert dialog and back to MainActivity
                    final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle("iShare");
                    alert.setMessage("Allow Contacts Permission to open send message"); // dialog message
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(ActivityContactList.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });


                    alert.show();

                }
                break;
        }
    }
    //for invite button
    public void GetContactsIntoArrayList() {


        // cursor for contacts
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        ModelContactsList md;
        if (cursor != null) {
            while (cursor.moveToNext()) {

                name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                //     img = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                md=new ModelContactsList(name,phonenumber);

                inviteList.add(md);

            }
            cursor.close();
        }


       /* // when the user add contact to her device
        for (int i = 0; i < StoreContacts.size(); i++) {
            md.setUserNameId(StoreContacts.get(i));
           // contac.setIsChecked(false);
            contactsList.add(contac);
        }*/

    }

}






