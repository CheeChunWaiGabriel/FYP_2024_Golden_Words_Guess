package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExpertActivity extends AppCompatActivity {
    Button btnBack;
    Button btnPuzzle1;
    Button btnPuzzle2;
    Button btnPuzzle3;
    Button btnPuzzle4;
    Button btnPuzzle5;
    Button btnPuzzle6;
    Button btnPuzzle7;
    Button btnPuzzle8;
    Button btnPuzzle9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.selectionpageexpert);

        btnBack = findViewById(R.id.htpBackExpert);
        btnPuzzle1 = findViewById(R.id.btnLevel1Expert);
        btnPuzzle2 = findViewById(R.id.btnLevel2Expert);
        btnPuzzle3 = findViewById(R.id.btnLevel3Expert);
        btnPuzzle4 = findViewById(R.id.btnLevel4Expert);
        btnPuzzle5 = findViewById(R.id.btnLevel5Expert);
        btnPuzzle6 = findViewById(R.id.btnLevel6Expert);
        btnPuzzle7 = findViewById(R.id.btnLevel7Expert);
        btnPuzzle8 = findViewById(R.id.btnLevel8Expert);
        btnPuzzle9 = findViewById(R.id.btnLevel9Expert);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, DifficultySelection.class);
                startActivity(intent);
            }
        });

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_English_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_English_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_English_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_Chinese_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_Chinese_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_Chinese_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this,Puzzlecode_Expert_Malay_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_Malay_2.class);
                startActivity(intent);
            }
        });
        btnPuzzle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, Puzzlecode_Expert_Malay_3.class);
                startActivity(intent);
            }
        });
    }
}