package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HowToPlay extends AppCompatActivity  {
    Button btnHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtoplay);

        btnHomePage = findViewById(R.id.htpHomeButton);

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HowToPlay.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
