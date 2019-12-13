package com.example.harman_c0765590_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        String name, email, phone;
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        phone = etPhone.getText().toString();

        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()){

        }
        else{
            Toast.makeText(this, "You should fill all the fields. ", Toast.LENGTH_SHORT).show();
        }

    }
}
