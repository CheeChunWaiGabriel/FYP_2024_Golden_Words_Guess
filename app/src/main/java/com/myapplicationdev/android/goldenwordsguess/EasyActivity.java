package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EasyActivity extends AppCompatActivity {
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
        setContentView(R.layout.selectionpageeasy);

        btnHome = findViewById(R.id.htpHomeButton);
        btnPuzzle1 = findViewById(R.id.btnLevel1Easy);
        btnPuzzle2 = findViewById(R.id.btnLevel2Easy);
        btnPuzzle3 = findViewById(R.id.btnLevel3Easy);
        btnPuzzle4 = findViewById(R.id.btnLevel4Easy);
        btnPuzzle5 = findViewById(R.id.btnLevel5Easy);
        btnPuzzle6 = findViewById(R.id.btnLevel6Easy);
        btnPuzzle7 = findViewById(R.id.btnLevel7Easy);
        btnPuzzle8 = findViewById(R.id.btnLevel8Easy);
        btnPuzzle9 = findViewById(R.id.btnLevel9Easy);


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_English_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_English_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_English_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_Chinese_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_Chinese_2.class);
                startActivity(intent);
            }
        });

        btnPuzzle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_Chinese_3.class);
                startActivity(intent);
            }
        });

        btnPuzzle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this,Puzzlecode_Easy_Malay_1.class);
                startActivity(intent);
            }
        });

        btnPuzzle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_Malay_2.class);
                startActivity(intent);
            }
        });
        btnPuzzle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, Puzzlecode_Easy_Malay_3.class);
                startActivity(intent);
            }
        });
    }
}