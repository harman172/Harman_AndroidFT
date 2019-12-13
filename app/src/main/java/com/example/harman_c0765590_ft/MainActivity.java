package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.harman_c0765590_ft.interfaces.UpdateListListener;
import com.example.harman_c0765590_ft.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UpdateListListener {

    private boolean isDualPane = false;
    private static List<UserModel> usersList = new ArrayList<>();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View detailsView = findViewById(R.id.frag_user_info);
        isDualPane = (detailsView != null) && (detailsView.getVisibility() == View.VISIBLE);


        Log.i("AddUser", "onCreate: ");



    }


    @Override
    public List<UserModel> updateList() {
        intent = getIntent();
        UserModel user = (UserModel) intent.getSerializableExtra("user");
        if (user != null){
            usersList.add(user);
            Log.i("AddUser", "onCreate0: " + usersList.size());
        }
        return usersList;
    }
}

