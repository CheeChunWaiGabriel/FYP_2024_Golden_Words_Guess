package com.myapplicationdev.android.goldenwordsguess;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.HashSet;
import java.util.Set;

public class Puzzlecode_Normal_Chinese_2 extends AppCompatActivity {

    private TextView[] boxes;
    private Button[] letterButtons;
    private int currentBoxIndex = 0;
    private final String correctWord = "三思而后行";

    private Button btnTryAgain;
    private Button btnHome;
    private Button btnUndo;
    private ImageView resultIndicator;
    private MediaPlayer buttonClick;
    private MediaPlayer correct;
    private MediaPlayer congratulations;
    private MediaPlayer wrong;
    private MediaPlayer retry;
    private MediaPlayer undo;

    private Set<String> correctLettersPressed = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout_normal_chinese_2);

        initializeViews();
        setLetterButtonListeners();
        setControlButtonListeners();
    }

    private void initializeViews() {
        boxes = new TextView[]{
                findViewById(R.id.box1),
                findViewById(R.id.box2),
                findViewById(R.id.box3),
                findViewById(R.id.box4),
                findViewById(R.id.box5)
        };

        letterButtons = new Button[]{
                findViewById(R.id.btn_letter_top),
                findViewById(R.id.btn_letter_left1),
                findViewById(R.id.btn_letter_right1),
                findViewById(R.id.btn_letter_left2),
                findViewById(R.id.btn_letter_right2)
        };

        btnTryAgain = findViewById(R.id.btn_try_again);
        btnHome = findViewById(R.id.btn_home);
        btnUndo = findViewById(R.id.btn_undo);
        resultIndicator = findViewById(R.id.result_indicator);
        buttonClick = MediaPlayer.create(this, R.raw.navbuttonpressed);
        congratulations = MediaPlayer.create(this, R.raw.clapping);
        correct = MediaPlayer.create(this, R.raw.correct);
        wrong = MediaPlayer.create(this, R.raw.wrong);
        retry = MediaPlayer.create(this, R.raw.retry);
        undo = MediaPlayer.create(this, R.raw.undo);

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

        animateButtonPress(button);

        button.setShadowLayer(0, 0, 0, Color.TRANSPARENT);

        button.setEnabled(false);

        vibrate();

        verifyLetter(button.getText().toString(), currentBoxIndex);
        currentBoxIndex++;
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(100);
            }
        }
    }

    private void animateButtonPress(Button button) {
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
            correct.start();

            correctLettersPressed.add(letter);

            if (index == boxes.length - 1) {
                congratulations.start();
                showResultIndicator(R.drawable.correct, resultIndicator);
            }
        } else {
            boxes[index].setBackgroundColor(ContextCompat.getColor(this, R.color.wrong_letter_color));
            showResultIndicator(R.drawable.wrong, resultIndicator);
            wrong.start();
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
                retry.start();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Puzzlecode_Normal_Chinese_2.this, NormalActivity.class));
                buttonClick.start();
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoLastMove();
                undo.start();
            }
        });
    }

    private void resetGame() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void undoLastMove() {
        if (currentBoxIndex > 0) {
            currentBoxIndex--;
            TextView lastBox = boxes[currentBoxIndex];
            String lastLetter = lastBox.getText().toString();
            lastBox.setText("");
            lastBox.setBackgroundResource(R.drawable.box_border);

            for (Button letterButton : letterButtons) {
                if (letterButton.getText().toString().equals(lastLetter)) {
                    if (!correctLettersPressed.contains(lastLetter)) {
                        letterButton.setEnabled(true);
                        letterButton.setShadowLayer(8, 20, 3, Color.parseColor("#E68900"));
                    }
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
            if (!correctLettersPressed.contains(letterButton.getText().toString())) {
                letterButton.setEnabled(true);
            }
        }
    }
}