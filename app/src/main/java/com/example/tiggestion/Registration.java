package com.example.tiggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
EditText email,password,repassword;
Button signup,exit;
DatabaseClass DB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.email=(EditText) findViewById(R.id.email);
        this.password=(EditText) findViewById(R.id.password);
        this.repassword=(EditText) findViewById(R.id.repassword);
        this.signup =(Button) this.findViewById(R.id.signup);
        this.exit =(Button) this.findViewById(R.id.exit);
        DB = new DatabaseClass(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail= email.getText().toString();
                String inputPassword= password.getText().toString();
                String inputRepassword= repassword.getText().toString();

                if(inputEmail.equals("")|| inputRepassword.equals("")||inputPassword.equals("")){
                    Toast.makeText(Registration.this,"Veuilez remplir les champs",Toast.LENGTH_SHORT).show();
                } else {
                    if(inputPassword.equals(inputRepassword)){
                        Boolean checkEmail = DB.checkEmail(inputEmail);
                        if(!checkEmail){
                            Boolean register = DB.createUser(inputEmail,inputPassword);
                            if(register){
                                Toast.makeText(Registration.this,"Compte crée avec sucess",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Registration.this,"Erreur survenu lors de l'inscription ",Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(Registration.this,"Vous avez deja un compte",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registration.this,"Mot de passe differents",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}