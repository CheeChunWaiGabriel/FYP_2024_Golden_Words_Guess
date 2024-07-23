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

        initializeViews();
        setLetterButtonListeners();
        setControlButtonListeners();
    }

    private void initializeViews() {
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
    }

    private void setLetterButtonListeners() {
        View.OnClickListener letterClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBoxIndex < boxes.length) {
                    Button button = (Button) view;
                    handleLetterSelection(button);
                }
            }
        };

        for (Button letterButton : letterButtons) {
            letterButton.setOnClickListener(letterClickListener);
        }
    }

    private void handleLetterSelection(Button button) {
        boxes[currentBoxIndex].setText(button.getText());
        button.setTextColor(ContextCompat.getColor(this, R.color.grey));
        button.setEnabled(false);
        verifyLetter(button.getText().toString(), currentBoxIndex);
        currentBoxIndex++;
    }

    private void verifyLetter(String letter, int index) {
        ImageView resultIndicator = findViewById(R.id.result_indicator);
        Button btnTryAgain = findViewById(R.id.btn_try_again);
        Button btnUndo = findViewById(R.id.btn_undo);

        if (correctWord.charAt(index) == letter.charAt(0)) {
            boxes[index].setBackgroundColor(ContextCompat.getColor(this, R.color.correct_letter_color));
            if (index == boxes.length - 1) {
                showResultIndicator(R.drawable.correct, resultIndicator);
            }
        } else {
            boxes[index].setBackgroundColor(ContextCompat.getColor(this, R.color.wrong_letter_color));
            showResultIndicator(R.drawable.wrong, resultIndicator);
            btnTryAgain.setVisibility(View.VISIBLE);
            btnUndo.setVisibility(View.VISIBLE);
            disableUnselectedLetterButtons();
        }
    }

    private void showResultIndicator(int drawableRes, ImageView resultIndicator) {
        resultIndicator.setImageResource(drawableRes);
        resultIndicator.setVisibility(View.VISIBLE);
    }

    private void setControlButtonListeners() {
        Button btnTryAgain = findViewById(R.id.btn_try_again);
        Button btnHome = findViewById(R.id.btn_home);
        Button btnUndo = findViewById(R.id.btn_undo);

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Puzzlecode.this, MainActivity.class));
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoLastMove();
            }
        });
    }

    private void resetGame() {
        ImageView resultIndicator = findViewById(R.id.result_indicator);
        Button btnTryAgain = findViewById(R.id.btn_try_again);
        Button btnUndo = findViewById(R.id.btn_undo);

        for (TextView box : boxes) {
            box.setText("");
            box.setBackgroundResource(R.drawable.box_border); // Reset to original drawable
        }

        currentBoxIndex = 0;
        resultIndicator.setVisibility(View.GONE);
        btnTryAgain.setVisibility(View.GONE);
        btnUndo.setVisibility(View.GONE);

        for (Button letterButton : letterButtons) {
            letterButton.setEnabled(true);
            letterButton.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void undoLastMove() {
        if (currentBoxIndex > 0) {
            currentBoxIndex--;
            TextView lastBox = boxes[currentBoxIndex];
            String lastLetter = lastBox.getText().toString();
            lastBox.setText("");
            lastBox.setBackgroundResource(R.drawable.box_border); // Reset to original drawable

            for (Button letterButton : letterButtons) {
                if (letterButton.getText().toString().equals(lastLetter)) {
                    letterButton.setEnabled(true);
                    letterButton.setTextColor(ContextCompat.getColor(this, R.color.black));
                    break;
                }
            }

            ImageView resultIndicator = findViewById(R.id.result_indicator);
            resultIndicator.setVisibility(View.GONE);
            findViewById(R.id.btn_try_again).setVisibility(View.GONE);
            findViewById(R.id.btn_undo).setVisibility(View.GONE);

            enableAllLetterButtons();
        }
    }

    private void disableUnselectedLetterButtons() {
        for (Button letterButton : letterButtons) {
            if (letterButton.isEnabled()) {
                letterButton.setEnabled(false);
            }
        }
    }

    private void enableAllLetterButtons() {
        for (Button letterButton : letterButtons) {
            letterButton.setEnabled(true);
        }
    }
}
