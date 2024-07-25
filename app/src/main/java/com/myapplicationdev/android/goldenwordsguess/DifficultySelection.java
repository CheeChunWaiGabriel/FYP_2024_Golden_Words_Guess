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
        View normalButton = findViewById(R.id.normalBtn);
        View hardButton = findViewById(R.id.expertBtn);
        Button btnHome = findViewById(R.id.btn_home);

        // Set click listeners for buttons
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, EasyActivity.class);
                startActivity(intent);
            }
        });

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultySelection.this, ExpertActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DifficultySelection.this, MainActivity.class));
            }
        });

}}
