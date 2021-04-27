package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText_Username);

        button.setOnClickListener(v -> {
            button.setText(R.string.logged);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("text", editText.getText().toString());
            startActivity(intent);
        });
    }
}