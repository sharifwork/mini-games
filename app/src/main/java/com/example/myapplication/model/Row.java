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

    public void setCode(TextView code) {
        this.code = code;
    }

    public void setNumGuess(TextView numGuess) {
        this.numGuess = numGuess;
    }

    public TextView getTextByIndex(int index){
        switch (index){
            case 0:
                return code;
            case 1:
                return numGuess;
            case 2:
                return numAnswer;
            default:
                return null;
        }
    }

    public void setTextByIndex(int index , TextView text){
        switch (index){
            case 0:
                code = text ;
            case 1:
                 numGuess = text;
            case 2:
                numAnswer = text;
        }
    }
}
