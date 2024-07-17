package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DifficultySelection extends AppCompatActivity {

    private Button buttonEasy;
    private Button buttonNormal;
    private Button buttonHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_selection);

        // Initialize buttons
        View easyButton = findViewById(R.id.easyBtn);
        View mediumButton = findViewById(R.id.normalBtn);
        View hardButton = findViewById(R.id.expertBtn);

        // Set click listeners for buttons
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, EasyActivity.class);
                startActivity(intent);
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, EasyActivity.class);
                startActivity(intent);
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, EasyActivity.class);
                startActivity(intent);
            }
        });

}}
