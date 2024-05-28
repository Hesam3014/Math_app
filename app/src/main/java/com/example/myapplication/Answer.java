package com.example.myapplication;

public class Answer {
    private int number1;
    private int number2;
    private char operator;
    private int userAnswer;
    private boolean isCorrect;

    private int answer;

    public Answer(int number1, int number2, char operator, int userAnswer, boolean isCorrect) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
        this.userAnswer = userAnswer;
        this.isCorrect = isCorrect;
        if (operator == '+') {
            answer = number1 + number2;
        } else if (operator == '-') {
            answer = number1 - number2;
        } else if (operator == '*') {
            answer = number1 * number2;
        }
    }

    @Override
    public String toString() {
        return number1 + " " + operator + " " + number2 + " = " + userAnswer + " (" + answer + ")"  ;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean isIncorrect() {
        return !isCorrect;
    }
}
