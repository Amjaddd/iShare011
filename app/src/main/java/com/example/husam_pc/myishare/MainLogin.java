package com.example.husam_pc.myishare;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainLogin extends AppCompatActivity {
    CallbackManager callbackManager;
    ProgressDialog mdialog;
    TextView txtEmail, txtName;
    // -----------------------------
    TextView email;


    RelativeLayout login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main_login);
        setPointer();
    }

    //Facebook code



    private void setPointer() {
        email = findViewById(R.id.email);
        email.setError("Erorr");
        login =  findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLogin.this,MainActivity.class);
                startActivity(intent);
            }

        });
        // For Facebook Login
/*
        txtEmail = findViewById(R.id.txtEmail);
        txtName = findViewById(R.id.txtName);

        @SuppressLint("WrongViewCast") LoginButton loginButton =  findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mdialog = new ProgressDialog(MainLogin.this);
                mdialog.setMessage("Retrieving data...");
                mdialog.show();
                String accesstoken = loginResult.getAccessToken().getToken();

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        mdialog.dismiss();
                        Log.d("response",response.toString());
                        getData(object);
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields","id,email,birthday,friends,name");

                request.setParameters(parameters);
                request.executeAsync();

            }
            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        // if already login
        if (AccessToken.getCurrentAccessToken() != null){

            // Just set user Id
            txtEmail.setText(AccessToken.getCurrentAccessToken().getUserId());
        }

    }
    @Override

    // Facebook Methods
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    public void getData(JSONObject object) {

        try {
            //   URL profile_picture = new URL("https://graph.facebook.com/" + object.getString("id") + "/picture?width=250&height=250");
            //   Picasso.with(this).load(profile_picture.toString()).into(imgAvatar);
            txtEmail.setText(object.getString("email"));
            //   txtBirthday.setText(object.getString("birthday"));
            //   txtFriends.setText("Friends: " + object.getJSONObject("friends").getJSONObject("summary").getString("total_count"));
            txtName.setText(object.getString("name"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }*/}
    // End of Facebook Method
}
