package com.example.myapplication.model;

import android.widget.TextView;

import java.util.ArrayList;

public class Team {
    private TextView name;
    private ArrayList<String> players;
    private ArrayList<Cell> cells = new ArrayList<>();
    private ArrayList<Cell> enemyCells = new ArrayList<>();
    private TextView [] words = new TextView[4];
    private Column[] columns = new Column[4];
    private int score;
    private Status status;

    public Team(){

        columns[0] = new Column();
        columns[1] = new Column();
        columns[2] = new Column();
        columns[3] = new Column();

    }
    public ArrayList<Cell> getCells() {
        return cells;
    }

    public Column[] getColumns() {
        return columns;
    }

    public int getScore() {
        return score;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getEnemyCells() {
        return enemyCells;
    }

    public void setEnemyCells(ArrayList<Cell> enemyCells) {
        this.enemyCells = enemyCells;
    }

    public TextView[] getWords() {
        return words;
    }

    public void setWords(TextView[] words) {
        this.words = words;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
        WAIT
        ,WRITE
        ,GUESS
        ,FINISH;
    }
}


