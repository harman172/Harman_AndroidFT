package com.example.harman_c0765590_ft.models;

import android.app.Activity;
import android.content.res.Resources;

import java.io.Serializable;
import java.util.Random;

public class UserModel implements Serializable {

    private String name, email, phone;
    private int imageID;


    public UserModel(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

        this.imageID = generateRandomNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getImageID() {
        return imageID;
    }

    private int generateRandomNumber(){


        Random random = new Random();
        int randomN = random.nextInt(30)+ 1;

        if (randomN > 0){
            return randomN;
        } else{
            return 1;
        }


    }
}
