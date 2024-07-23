package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NormalActivity extends AppCompatActivity {
    Button btnHome;
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
        setContentView(R.layout.selectionpagenormal);

        btnHome = findViewById(R.id.htpHomeButtonNormal);
        btnPuzzle1 = findViewById(R.id.btnLevel1Normal);
        btnPuzzle2 = findViewById(R.id.btnLevel2Normal);
        btnPuzzle3 = findViewById(R.id.btnLevel3Normal);
        btnPuzzle4 = findViewById(R.id.btnLevel4Normal);
        btnPuzzle5 = findViewById(R.id.btnLevel5Normal);
        btnPuzzle6 = findViewById(R.id.btnLevel6Normal);
        btnPuzzle7 = findViewById(R.id.btnLevel7Normal);
        btnPuzzle8 = findViewById(R.id.btnLevel8Normal);
        btnPuzzle9 = findViewById(R.id.btnLevel9Normal);


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_English_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_English_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_English_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_Chinese_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_Chinese_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_Chinese_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this,Puzzlecode_Normal_Malay_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_Malay_2.class);
                startActivity(intent);
            }
        });
        btnPuzzle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, Puzzlecode_Normal_Malay_3.class);
                startActivity(intent);
            }
        });
    }
}