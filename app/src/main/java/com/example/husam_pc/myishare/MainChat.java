package com.example.husam_pc.myishare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainChat extends AppCompatActivity {

    TextView nameID,iconID,status;
    View view;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        this.context=this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // iconID = (TextView) findViewById(R.id.iconID);
        //nameID = (TextView) findViewById(R.id.userName);
        //status = (TextView) findViewById(R.id.status);

       /* Intent intent= getIntent();
        String DPID = intent.getStringExtra("DPID");
        String name = intent.getStringExtra("Name");
        String stat = intent.getStringExtra("Status");
        iconID.setText(DPID);
        nameID.setText(name);
        if (!stat.isEmpty())
            status.setText(stat);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.route,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.actoin_route){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
