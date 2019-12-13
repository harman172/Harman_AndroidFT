package com.example.harman_c0765590_ft.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harman_c0765590_ft.R;
import com.example.harman_c0765590_ft.models.UserModel;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<UserModel> usersList;

    public UserListAdapter(Context context, List<UserModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_user_list, null);
        }

        ImageView imageView = convertView.findViewById(R.id.iv_ad_user);

        TextView tvName, tvEmail, tvPhone;
        tvName = convertView.findViewById(R.id.tv_ad_name);
        tvEmail = convertView.findViewById(R.id.tv_ad_email);
        tvPhone = convertView.findViewById(R.id.tv_ad_phone);

        int number = usersList.get(position).getImageID();

        String imgName;

        if (number < 10){
            imgName = "icon01_0" + number;
        } else{
            imgName = "icon01_" + number;
        }
        Log.i("Image", "getView: "+ imgName);

        Resources resources = context.getResources();
        int id = resources.getIdentifier(imgName, "drawable", context.getPackageName());

        imageView.setImageResource(id);

        tvName.setText(usersList.get(position).getName());
        tvEmail.setText(usersList.get(position).getEmail());
        tvPhone.setText(usersList.get(position).getPhone());

        return convertView;
    }
}
