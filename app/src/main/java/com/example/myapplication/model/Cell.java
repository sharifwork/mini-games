package com.example.myapplication.model;

import android.widget.TextView;

public class Cell {
    private TextView author;
    private final Row[] rows = new Row[3];
    private TextView score;

    public Cell(){
        rows[0] = new Row();
        rows[1] = new Row();
        rows[2] = new Row();
    }
    public void setStringScore(int score) {
        this.score.setText(""+score);
    }

    public TextView getAuthor() {
        return author;
    }

    public Row[] getRows() {
        return rows;
    }

    public TextView getScore() {
        return score;
    }
}
