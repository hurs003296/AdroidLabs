package com.example.lab3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        Button buttonNext = findViewById(R.id.buttonNext);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String savedName = sharedPreferences.getString("name", "");
        if (!savedName.isEmpty()) {
            editTextName.setText(savedName);
        }

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                Intent intent = new Intent(MainActivity.this, com.example.lab3.NameActivity.class);
                intent.putExtra("name", name);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        String name = editTextName.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 0) {
                editTextName.setText("");
            } else if (resultCode == 1) {
                finish();
            }
        }
    }
}
