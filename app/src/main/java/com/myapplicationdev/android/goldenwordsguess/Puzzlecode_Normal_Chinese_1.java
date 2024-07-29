package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Puzzlecode_Normal_Chinese_1 extends AppCompatActivity {

    private TextView[] boxes;
    private Button[] buttons;
    private int currentBoxIndex = 0;
    private final String correctWord = "天下无敌手";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout_normal_chinese_1);

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

        buttons = new Button[]{
                btnTop, btnLeft1, btnRight1, btnLeft2, btnRight2
        };

        View.OnClickListener letterClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBoxIndex < boxes.length) {
                    Button button = (Button) view;
                    boxes[currentBoxIndex].setText(button.getText());
                    button.setTextColor(ContextCompat.getColor(Puzzlecode_Normal_Chinese_1.this, R.color.grey));
                    button.setEnabled(false);
                    currentBoxIndex++;

                    if (currentBoxIndex == boxes.length) {
                        verifyWord(resultIndicator, btnTryAgain);
                    }
                }
            }
        };

        for (Button button : buttons) {
            button.setOnClickListener(letterClickListener);
        }

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
                Intent intent = new Intent(Puzzlecode_Normal_Chinese_1.this, NormalActivity.class);
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

