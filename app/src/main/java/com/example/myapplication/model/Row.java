package com.example.myapplication.model;

import android.widget.TextView;

public class Row {
    private TextView code ;
    private TextView numGuess;
    private TextView numAnswer;

    public TextView getCode() {
        return code;
    }

    public void setStringCode(String code) {
        this.code.setText(code);
    }

    public TextView getNumGuess() {
        return numGuess;
    }

    public void setStringNumGuess(int numGuess) {
        this.numGuess.setText("" + numGuess);
    }

    public TextView getNumAnswer() {
        return numAnswer;
    }

    public void setNumAnswer(TextView numAnswer) {
        this.numAnswer = numAnswer;
    }
}
