package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.harman_c0765590_ft.fragments.UserDetailsFragment;
import com.example.harman_c0765590_ft.models.UserModel;

import java.util.List;

public class UserDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        UserDetailsFragment descriptionFragment = (UserDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.frag_user_info);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("index");
        List<UserModel> list = (List<UserModel>) intent.getSerializableExtra("list");
        descriptionFragment.displayDetails(id,list);
    }
}
