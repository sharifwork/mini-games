package com.example.myapplication.model;

import android.widget.TextView;

import java.util.ArrayList;

public class Column {
    private TextView answer;
    private ArrayList<TextView> codes;
    private TextView guess;

    public TextView getAnswer() {
        return answer;
    }

    public void setStringAnswer(String answer) {
        this.answer.setText(answer);
    }

    public ArrayList<TextView> getCodes() {
        return codes;
    }

    public void setCodes(ArrayList<TextView> codes) {
        this.codes = codes;
    }

    public TextView getGuess() {
        return guess;
    }

    public void setGuess(TextView guess) {
        this.guess = guess;
    }
}
