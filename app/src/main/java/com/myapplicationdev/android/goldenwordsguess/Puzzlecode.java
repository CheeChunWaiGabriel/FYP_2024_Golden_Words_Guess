
package com.myapplicationdev.android.goldenwordsguess;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class Puzzlecode extends AppCompatActivity {

    private TextView tvWord;
    private GridLayout glLetters;
    private Button btnSubmit;
    private Set<String> validWords;
    private StringBuilder currentWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWord = findViewById(R.id.tv_word);
        glLetters = findViewById(R.id.gl_letters);
        btnSubmit = findViewById(R.id.btn_submit);
        validWords = new HashSet<>();
        currentWord = new StringBuilder();

        // Example valid words
        validWords.add("CAB");
        validWords.add("ABC");

        setupLetterButtons();
        setupSubmitButton();
    }

    private void setupLetterButtons() {
        for (int i = 0; i < glLetters.getChildCount(); i++) {
            View view = glLetters.getChildAt(i);
            if (view instanceof Button) {
                Button button = (Button) view;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentWord.append(button.getText().toString());
                        tvWord.setText(currentWord.toString());
                    }
                });
            }
        }
    }

    private void setupSubmitButton() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = currentWord.toString();
                if (validWords.contains(word)) {
                    Toast.makeText(Puzzlecode.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Puzzlecode.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }
                currentWord.setLength(0);
                tvWord.setText("");
            }
        });
    }
}
