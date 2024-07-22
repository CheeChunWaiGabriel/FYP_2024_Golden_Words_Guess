package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Puzzlecode extends AppCompatActivity {

    private TextView[] boxes;
    private Button[] letterButtons;
    private int currentBoxIndex = 0;
    private final String correctWord = "TAXI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout);

        boxes = new TextView[]{
                findViewById(R.id.box1),
                findViewById(R.id.box2),
                findViewById(R.id.box3),
                findViewById(R.id.box4)
        };

        letterButtons = new Button[]{
                findViewById(R.id.btn_letter_top),
                findViewById(R.id.btn_letter_left),
                findViewById(R.id.btn_letter_right),
                findViewById(R.id.btn_letter_bottom)
        };

        Button btnTryAgain = findViewById(R.id.btn_try_again);
        Button btnHome = findViewById(R.id.btn_home);
        Button btnUndo = findViewById(R.id.btn_undo);
        ImageView resultIndicator = findViewById(R.id.result_indicator);

        View.OnClickListener letterClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBoxIndex < boxes.length) {
                    Button button = (Button) view;
                    boxes[currentBoxIndex].setText(button.getText());
                    boxes[currentBoxIndex].setBackgroundColor(ContextCompat.getColor(Puzzlecode.this, R.color.box_filled_color));
                    button.setTextColor(ContextCompat.getColor(Puzzlecode.this, R.color.grey));
                    button.setEnabled(false);
                    currentBoxIndex++;

                    if (currentBoxIndex == boxes.length) {
                        verifyWord(resultIndicator, btnTryAgain);
                    }
                }
            }
        };

        for (Button letterButton : letterButtons) {
            letterButton.setOnClickListener(letterClickListener);
        }

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame(resultIndicator, btnTryAgain);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Puzzlecode.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBoxIndex > 0) {
                    currentBoxIndex--;
                    TextView lastBox = boxes[currentBoxIndex];
                    String lastLetter = lastBox.getText().toString();
                    lastBox.setText("");
                    lastBox.setBackgroundColor(ContextCompat.getColor(Puzzlecode.this, R.color.white));
                    for (Button letterButton : letterButtons) {
                        if (letterButton.getText().toString().equals(lastLetter)) {
                            letterButton.setEnabled(true);
                            letterButton.setTextColor(ContextCompat.getColor(Puzzlecode.this, R.color.black));
                            break;
                        }
                    }
                }
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
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i].getText().toString().charAt(0) != correctWord.charAt(i)) {
                    boxes[i].setBackgroundColor(ContextCompat.getColor(this, R.color.wrong_letter_color));
                }
            }
        }
        resultIndicator.setVisibility(View.VISIBLE);
    }

    private void resetGame(ImageView resultIndicator, Button btnTryAgain) {
        for (TextView box : boxes) {
            box.setText("");
            box.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }
        currentBoxIndex = 0;
        resultIndicator.setVisibility(View.GONE);
        btnTryAgain.setVisibility(View.GONE);

        for (Button letterButton : letterButtons) {
            letterButton.setEnabled(true);
            letterButton.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }
}


