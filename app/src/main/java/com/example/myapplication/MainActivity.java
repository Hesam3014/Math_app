package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView number1TextView, operatorTextView, number2TextView;
    EditText answerEditText;
    Button checkButton, resetButton, nextButton;
    int number1, number2, result;
    char operator;

    String check ;
    int asnwer ;

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
        nextButton = findViewById(R.id.nextpage);

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

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                go_to();
                //String url = "https://www.google.com";
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                //startActivity(intent);
                //openGoogle();


                }
            });

    }

    private void generateNumbersAndOperator() {
        Random random = new Random();
        number1 = random.nextInt(100); // Generate random number between 0 and 99
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
                asnwer=result;
                break;
            case '-':
                result = number1 - number2;
                asnwer=result;
                break;
            case '*':
                result = number1 * number2;
                asnwer=result;
                break;
        }

        if (userAnswer == result) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            check ="correct";
        } else {
            Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            check="incorrect";
        }
    }
    public void go_to(){
        // Get the string to send
        String messageToSend = check;

        // Create Intent to start MainActivity2
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        // Convert the integer to a string
        String resultAsString = String.valueOf(result);

        // Put the string into the Intent
        intent.putExtra("messageKey", resultAsString);
        intent.putExtra("messegekey2" , check);

        // Start MainActivity2 with the Intent
        startActivity(intent);
    }

    private void reset() {
        answerEditText.setText("");
        generateNumbersAndOperator();
    }

    private void openGoogle() {
        String url = "https://www.google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
