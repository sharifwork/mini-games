package com.example.myapplication.model;

import android.widget.TextView;

import java.util.ArrayList;

public class Column {
    private TextView answer;
    private ArrayList<TextView> codes = new ArrayList<>();
    private TextView guess;

    public TextView getAnswer() {
        return answer;
    }

    public void setStringAnswer(String answer) {
        this.answer.setText(answer);
    }

    public void setAnswer(TextView answer) {
        this.answer = answer;
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

    public void addCode(TextView code){
        codes.add(code);
    }

    public TextView getTextByIndex(int index){
        if(index>=0 && index<= 5) return codes.get(index);
        if(index == 6) return guess;
        if(index == 7) return answer;
        return null;
    }

    public void setTextByIndex(int index , TextView text){
        if(index>=0 && index<= 5) codes.add(index , text);
        else if(index == 6)  guess = text;
        else if(index == 7) answer = text;
    }
}
