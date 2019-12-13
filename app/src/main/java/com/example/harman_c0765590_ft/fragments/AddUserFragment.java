package com.example.harman_c0765590_ft.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.harman_c0765590_ft.R;
import com.example.harman_c0765590_ft.RegistrationActivity;
import com.example.harman_c0765590_ft.adapters.UserListAdapter;
import com.example.harman_c0765590_ft.interfaces.UpdateListListener;
import com.example.harman_c0765590_ft.models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private Context context;
    private UpdateListListener updateListListener;
    private List<UserModel> list;


    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.updateListListener = (UpdateListListener) context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        Button button = view.findViewById(R.id.btn_add_user);
        ListView listView = view.findViewById(R.id.users_list);

        list = updateListListener.updateList();
        Log.i("AddUser", "onCreateView Frag: " + list.size());


        UserListAdapter listAdapter = new UserListAdapter(context,list);

        listView.setAdapter(listAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}


