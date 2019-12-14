package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.harman_c0765590_ft.fragments.UserDetailsFragment;
import com.example.harman_c0765590_ft.interfaces.OnListItemClickListener;
import com.example.harman_c0765590_ft.interfaces.UpdateListListener;
import com.example.harman_c0765590_ft.models.UserModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UpdateListListener, OnListItemClickListener {

    private boolean isDualPane = false;
    private static List<UserModel> usersList = new ArrayList<>();

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

        Log.i("AddUser", "onCreate0: ");
        Intent intent = getIntent();
        UserModel user = (UserModel) intent.getSerializableExtra("user");
        if (user != null){
            usersList.add(user);
        }
        return usersList;
    }

    @Override
    public void onclick(int index) {
        if (isDualPane) {
            UserDetailsFragment descriptionFragment = (UserDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.frag_user_info);
            descriptionFragment.displayDetails(index, usersList);
        } else {

            Intent intent = new Intent(this, UserDetailsActivity.class);
            intent.putExtra("index", index);
            intent.putExtra("list", (Serializable) usersList);
            startActivity(intent);
        }
    }
}

