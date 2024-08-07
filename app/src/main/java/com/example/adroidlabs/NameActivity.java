package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView textViewWelcome = findViewById(R.id.textViewWelcome);
        Button buttonThankYou = findViewById(R.id.buttonThankYou);
        Button buttonDontCallMe = findViewById(R.id.buttonDontCallMe);

        String name = getIntent().getStringExtra("name");
        textViewWelcome.setText(getString(R.string.welcome_message, name));

        buttonThankYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });

        buttonDontCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });
    }
}
