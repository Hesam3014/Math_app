package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView number1TextView, operatorTextView, number2TextView;
    EditText answerEditText;
    Button checkButton, resetButton, viewResultsButton;
    int number1, number2, result;
    char operator;
    static ArrayList<Answer> answersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1TextView = findViewById(R.id.number1TextView);
        operatorTextView = findViewById(R.id.operatorTextView);
        number2TextView = findViewById(R.id.number2TextView);
        answerEditText = findViewById(R.id.answerEditText);
        checkButton = findViewById(R.id.checkButton);
        resetButton = findViewById(R.id.resetButton);
        viewResultsButton = findViewById(R.id.viewResultsButton);

        generateNumbersAndOperator();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        viewResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void generateNumbersAndOperator() {
        Random random = new Random();
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        operator = getRandomOperator();
        number1TextView.setText(String.valueOf(number1));
        number2TextView.setText(String.valueOf(number2));
        operatorTextView.setText(String.valueOf(operator));
    }

    private char getRandomOperator() {
        Random random = new Random();
        int op = random.nextInt(3);
        if (op == 0)
            return '+';
        else if (op == 1)
            return '-';
        else
            return '*';
    }

    private void checkAnswer() {
        int userAnswer;
        try {
            userAnswer = Integer.parseInt(answerEditText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
        }

        boolean isCorrect = (userAnswer == result);
        answersList.add(new Answer(number1, number2, operator, userAnswer, isCorrect));
        Toast.makeText(MainActivity.this, isCorrect ? "Correct!" : "Incorrect!", Toast.LENGTH_SHORT).show();
    }

    private void reset() {
        answerEditText.setText("");
        generateNumbersAndOperator();
    }
}
