package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.harman_c0765590_ft.adapters.RobotCellAdapter;

import java.util.Random;

public class VerifyRobotActivity extends AppCompatActivity {

    int[] trafficImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
            R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

    int[] checked = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    int[] correctData = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    private CheckBox cbRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_robot);

        final GridView gridView = findViewById(R.id.grid_view);
        final ImageView ivRefresh = findViewById(R.id.iv_refresh);
        cbRobot = findViewById(R.id.cb_robot);

        final RobotCellAdapter cellAdapter = new RobotCellAdapter(this, trafficImages,0);
        gridView.setAdapter(cellAdapter);


        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0; i<checked.length; i++){
                    checked[i] = -1;
                }

                ivRefresh.setRotation(ivRefresh.getRotation() + 90);
                trafficImages = shuffleImages(trafficImages);
                cellAdapter.notifyDataSetChanged();
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = view.findViewById(R.id.iv_cell);

                if (checked[position] == -1){


                    imageView.setImageResource(R.drawable.checked);
                    imageView.animate().alpha(0.5f);
                    checked[position] = 0;
                } else{
                    imageView.setImageResource(0);
                    imageView.animate().alpha(1.0f);
                    checked[position] = -1;
                }

            }
        });

    }

    public void onVerification(View view){

        int count = 0;
        boolean isChosen = false;

        for (int i = 0; i<checked.length; i++){

            if (checked[i] == 0){
                isChosen = true;

                for (int j=0 ; j<correctData.length; j++){

                    if (trafficImages[i] == correctData[j]){

                        Log.i("loop", "chosen: " + trafficImages[i]);
                        Log.i("loop", "correct: " + correctData[j]);
                        count += 1;

                        break;
                    }
                }

            }

        }

        Log.i("count", "onVerification: " + count);

        if (isChosen){
            if (cbRobot.isChecked()){
                if(count == 4 ) {
                    alert("Congratulations!!", "Verified");
                }else{
                    alert("Oooops!", "Not verified");
                }
            } else{
                Toast.makeText(this, "Please check the box.", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Please choose correct images.", Toast.LENGTH_SHORT).show();
        }


    }




    private void alert(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(VerifyRobotActivity.this, MainActivity.class);
                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle(title);
        alertDialog.show();
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
