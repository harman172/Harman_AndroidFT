package com.example.harman_c0765590_ft.fragments;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harman_c0765590_ft.R;
import com.example.harman_c0765590_ft.models.UserModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailsFragment extends Fragment {


    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public UserDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

    public void displayDetails(int index, List<UserModel> list){
        View view = getView();
        if (view != null){
            TextView tvName, tvEmail, tvPhone;
            ImageView ivProfile;

            tvName = view.findViewById(R.id.tv_name);
            tvEmail = view.findViewById(R.id.tv_email);
            tvPhone = view.findViewById(R.id.tv_phone);
            ivProfile = view.findViewById(R.id.iv_user);

            tvName.setText(list.get(index).getName());
            tvEmail.setText(list.get(index).getEmail());
            tvPhone.setText(list.get(index).getPhone());

            int number = list.get(index).getImageID();

            String imageName = String.format("icon01_%02d", number);

//            if (number < 10){
//                imgName = "icon01_0" + number;
//            } else{
//                imgName = "icon01_" + number;
//            }
//            Log.i("Image", "getView: "+ imgName);

            Resources resources = context.getResources();
            int id = resources.getIdentifier(imageName, "drawable", context.getPackageName());

            ivProfile.setImageResource(id);
        }
    }
}
