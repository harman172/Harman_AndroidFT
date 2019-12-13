package com.example.harman_c0765590_ft.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.harman_c0765590_ft.R;

import java.util.Random;

public class RobotCellAdapter extends BaseAdapter {

    private Context context;
    private int[] trafficImages;

    public RobotCellAdapter(Context context, int[] trafficImages) {
        this.context = context;
        this.trafficImages = trafficImages;
    }

    @Override
    public int getCount() {
        return trafficImages.length;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_robot_cell,null);
        }

        ImageView imageView = convertView.findViewById(R.id.iv_cell);

//        int[] images = shuffleImages(trafficImages);
        imageView.setImageResource(trafficImages[position]);


        return convertView;
    }
    

}
