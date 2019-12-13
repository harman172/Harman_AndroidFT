package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.harman_c0765590_ft.adapters.RobotCellAdapter;

import java.util.Random;

public class VerifyRobotActivity extends AppCompatActivity {

    int[] trafficImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
            R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_robot);

        GridView gridView = findViewById(R.id.grid_view);
        final ImageView ivRefresh = findViewById(R.id.iv_refresh);

        final RobotCellAdapter cellAdapter = new RobotCellAdapter(this, trafficImages);
        gridView.setAdapter(cellAdapter);



        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivRefresh.setRotation(ivRefresh.getRotation() + 90);
                trafficImages = shuffleImages(trafficImages);
                cellAdapter.notifyDataSetChanged();
            }
        });

    }

    public int[] shuffleImages(int[] images){
        Random rand = new Random();

        for (int i = 0; i < images.length; i++) {
            int randomIndexToSwap = rand.nextInt(images.length);
            int temp = images[randomIndexToSwap];
            images[randomIndexToSwap] = images[i];
            images[i] = temp;
        }

        return images;
    }
}
