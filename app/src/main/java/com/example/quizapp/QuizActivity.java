package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private RadioGroup firstRadioGroup;
    private TextView editText;
    private CheckBox checkjhon;
    private CheckBox checklady;
    private CheckBox checkcharles;
    private CheckBox checkblaise;
    private RadioGroup secondRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        checkjhon = findViewById(R.id.chk_1935);
        checklady = findViewById(R.id.chk_1946);
        checkcharles = findViewById(R.id.chk_1996);
        checkblaise = findViewById(R.id.chk_1998);
        firstRadioGroup=findViewById(R.id.first_Radio_Group);
        secondRadioGroup=findViewById(R.id.second_Radio_Group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;
                if (firstRadioGroup.getCheckedRadioButtonId() == R.id.radio_john)
                {
                    score += 1;
                }
                if (secondRadioGroup.getCheckedRadioButtonId() == R.id.radio_tax) {
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if (userAnswer.equalsIgnoreCase("solid") && userAnswer.equalsIgnoreCase("Solid")) {
                    score += 1;
                }

                if (checkjhon.isChecked() && !checklady.isChecked() && !checkcharles.isChecked() && checkblaise.isChecked()) {
                    score += 1;
                }

                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score + "/4");
                startActivity(intent);
            }
        });
    }
}
