package com.example.tiggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
EditText email,password,repassword;
Button signup,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.email=(EditText) findViewById(R.id.email);
        this.password=(EditText) findViewById(R.id.password);
        this.repassword=(EditText) findViewById(R.id.repassword);
        this.signup =(Button) this.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}