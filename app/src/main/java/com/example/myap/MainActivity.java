package com.example.myap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText[] unitEditTexts = new EditText[8];
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitEditTexts[0] = findViewById(R.id.unit1EditText);
        unitEditTexts[1] = findViewById(R.id.unit2EditText);
        unitEditTexts[2] = findViewById(R.id.unit3EditText);
        unitEditTexts[3] = findViewById(R.id.unit4EditText);
        unitEditTexts[4] = findViewById(R.id.unit5EditText);
        unitEditTexts[5] = findViewById(R.id.unit6EditText);
        unitEditTexts[6] = findViewById(R.id.unit7EditText);
        unitEditTexts[7] = findViewById(R.id.unit8EditText);

        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculateGrade() {
        int totalScore = 0;
        for (int i = 0; i < 8; i++) {
            String unitText = unitEditTexts[i].getText().toString();
            if (unitText.isEmpty()) {
                resultTextView.setText("Please enter all unit marks.");
                return;
            }
            int unitScore = Integer.parseInt(unitText);
            totalScore += unitScore;
        }

        if (totalScore / 8 >= 78 ) {
            resultTextView.setText("Grade: A");
        } else if (totalScore / 8 >= 60 ) {
            resultTextView.setText("Grade: B");
        } else if (totalScore/ 8 >= 40 ) {
            resultTextView.setText("Grade: F");
        } else {
            resultTextView.setText("Failed");
        }
    }
}
