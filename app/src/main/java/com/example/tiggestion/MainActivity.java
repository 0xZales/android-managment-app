package com.example.tiggestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private Button toRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.toRegister =(Button) this.findViewById(R.id.goregister);
        toRegister.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, Registration.class);
                // Start Example1Activity.
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}