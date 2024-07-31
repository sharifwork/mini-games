package com.example.myapplication.model;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<String> players;
    private ArrayList<Cell> cells;
    private ArrayList<Cell> enemyCells;
    private String [] words = new String[4];
    private Column[] columns = new Column[4];
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public ArrayList<Cell> getEnemyBoard() {
        return enemyCells;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words){
        this.words = words;
    }

    public Column[] getColumns() {
        return columns;
    }

    public int getScore() {
        return score;
    }

    public Cell getMyLastCell(){
        return cells.get(cells.size()-1);
    }

    public Cell getEnemyLastCell(){
        return enemyCells.get(enemyCells.size()-1);
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }
}
