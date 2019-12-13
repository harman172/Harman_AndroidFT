package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harman_c0765590_ft.models.UserModel;

public class RegistrationActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);



    }

    public void onSaveClick(View view){

//        Toast.makeText(this, "REgisterrrrrr meeee", Toast.LENGTH_SHORT).show();

        String name, email, phone;
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        phone = etPhone.getText().toString();

        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()){

            UserModel userModel = new UserModel(name, email, phone);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user",userModel);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "You should fill all the fields. ", Toast.LENGTH_SHORT).show();
        }

    }
}
