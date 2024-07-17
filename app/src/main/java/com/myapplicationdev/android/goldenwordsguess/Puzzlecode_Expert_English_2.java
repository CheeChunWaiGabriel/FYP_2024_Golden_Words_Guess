package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Puzzlecode_Expert_English_2 extends AppCompatActivity {

    private TextView[] boxes;
    private int currentBoxIndex = 0;
    private final String correctWord = "WHEAT";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.puzzle_layout_normal_english_3);

        boxes = new TextView[]{
                findViewById(R.id.box1),
                findViewById(R.id.box2),
                findViewById(R.id.box3),
                findViewById(R.id.box4),
                findViewById(R.id.box5)
        };

        Button btnTop = findViewById(R.id.btn_letter_top);
        Button btnLeft1 = findViewById(R.id.btn_letter_left1);
        Button btnRight1 = findViewById(R.id.btn_letter_right1);
        Button btnLeft2 = findViewById(R.id.btn_letter_left2);
        Button btnRight2 = findViewById(R.id.btn_letter_right2);
        Button btnTryAgain = findViewById(R.id.btn_try_again);
        Button btnHome = findViewById(R.id.btn_home);
        ImageView resultIndicator = findViewById(R.id.result_indicator);

        View.OnClickListener letterClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBoxIndex < boxes.length) {
                    Button button = (Button) view;
                    boxes[currentBoxIndex].setText(button.getText());
                    currentBoxIndex++;

                    if (currentBoxIndex == boxes.length) {
                        verifyWord(resultIndicator, btnTryAgain);
                    }
                }
            }
        };

        btnTop.setOnClickListener(letterClickListener);
        btnLeft1.setOnClickListener(letterClickListener);
        btnRight1.setOnClickListener(letterClickListener);
        btnLeft2.setOnClickListener(letterClickListener);
        btnRight2.setOnClickListener(letterClickListener);

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame(resultIndicator, btnTryAgain);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Puzzlecode_Expert_English_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void verifyWord(ImageView resultIndicator, Button btnTryAgain) {
        StringBuilder formedWord = new StringBuilder();
        for (TextView box : boxes) {
            formedWord.append(box.getText().toString());
        }

        if (formedWord.toString().equals(correctWord)) {
            resultIndicator.setImageResource(R.drawable.correct);
        } else {
            resultIndicator.setImageResource(R.drawable.wrong);
            btnTryAgain.setVisibility(View.VISIBLE);
        }
        resultIndicator.setVisibility(View.VISIBLE);
    }

    private void resetGame(ImageView resultIndicator, Button btnTryAgain) {
        for (TextView box : boxes) {
            box.setText("");
        }
        currentBoxIndex = 0;
        resultIndicator.setVisibility(View.GONE);
        btnTryAgain.setVisibility(View.GONE);
    }
}

