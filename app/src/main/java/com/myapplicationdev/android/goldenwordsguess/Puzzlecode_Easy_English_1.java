package com.myapplicationdev.android.goldenwordsguess;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Puzzlecode_Easy_English_1 extends AppCompatActivity {

    private TextView[] boxes;
    private Button[] letterButtons;
    private int currentBoxIndex = 0;
    private final String correctWord = "WOLF";

    private Button btnTryAgain;
    private Button btnHome;
    private Button btnUndo;
    private ImageView resultIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout_easy_english_1);

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

        btnTryAgain = findViewById(R.id.btn_try_again);
        btnHome = findViewById(R.id.btn_home);
        btnUndo = findViewById(R.id.btn_undo);
        resultIndicator = findViewById(R.id.result_indicator);
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
        // Set the text of the current box to the selected letter
        boxes[currentBoxIndex].setText(button.getText());

        // Change the button color and disable it
        button.setTextColor(ContextCompat.getColor(this, R.color.black));
        button.setEnabled(false);

        // Animate the button to indicate it has been pressed
        animateButtonPress(button);

        // Clear shadow layer
        button.setShadowLayer(0, 0, 0, Color.TRANSPARENT);

        // Verify the letter and proceed
        verifyLetter(button.getText().toString(), currentBoxIndex);
        currentBoxIndex++;
    }

    private void animateButtonPress(Button button) {
        // Create a simple scale animation to make the button appear pressed
        button.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(100)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        button.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(100)
                                .start();
                    }
                })
                .start();
    }



    private void verifyLetter(String letter, int index) {
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
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Puzzlecode_Easy_English_1.this, EasyActivity.class));
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

            resultIndicator.setVisibility(View.GONE);
            btnTryAgain.setVisibility(View.GONE);
            btnUndo.setVisibility(View.GONE);

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
