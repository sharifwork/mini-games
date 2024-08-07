package com.example.myapplication.controller;

import com.example.myapplication.model.Cell;
import com.example.myapplication.model.Row;
import com.example.myapplication.model.Status;
import com.example.myapplication.model.Team;
import com.example.myapplication.utlls.Result;
import com.example.myapplication.utlls.Util;

import java.util.ArrayList;

public class GameController {

    private Team team1 ;
    private Team team2 ;
    private boolean isTeam1Turn ;
    private int time;
    private int roundNumber;
    private final int[] numCodes = new int[3];
    private Team loggedTeam ;

    public GameController(){
        team1 = new Team() ;
        team2 = new Team() ;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Result gameSetup (){

        //add cells
        for (int i = 0; i < 2; i++) {
            Team team;
            if(i == 0) team = team1;
            else team = team2;
            for (int j = 0; j < roundNumber; j++) {
                    team.getCells().add(new Cell());
                    team.getEnemyCells().add(new Cell());
            }
        }

        assigningRandomTurn();

        loggedTeam = getTeamThisRound();

        getTeamThisRound().setStatus(Team.Status.WRITE);
        getTeamNextRound2().setStatus(Team.Status.WAIT);

        return new Result(true , "setup done");
    }

    public Team getLoggedTeam() {
        return loggedTeam;
    }

    public void setLoggedTeam(Team loggedTeam) {
        this.loggedTeam = loggedTeam;
    }

    private void assigningRandomTurn(){
        boolean random = Util.getRandom().nextBoolean();
        isTeam1Turn = random;
    }

    public Result typeCodeInCell(int index , String code){
        if(index<0 || index>2)return new Result(false , "index is out of bound");

        getTeamThisRound().getMyLastCell().getRows()[index].setStringCode(code);
        return new Result(true , "your code has set successfully");
    }

    public Team getTeamThisRound(){
        if(isTeam1Turn) return team1;
        else return team2;
    }

    public Team getTeamNextRound2(){
        if(isTeam1Turn) return team2;
        else return team1;
    }

    public Team getOpponent(){
        if(isTeam1Turn) return team2;
        else  return team1;
    }

    public void changeTurn(){
        if(isTeam1Turn) isTeam1Turn=false;
        else isTeam1Turn = true;
    }

    private void processAfterRound(){
        if(isMatchGuessWithAnswer(getTeamThisRound())) getTeamThisRound().getMyLastCell().setStringScore(0);
        else getTeamThisRound().getMyLastCell().setStringScore(-1);
        if(isMatchGuessWithAnswer(getOpponent())) getOpponent().getEnemyLastCell().setStringScore(1);
        else getOpponent().getEnemyLastCell().setStringScore(0);
    }

    private boolean isMatchGuessWithAnswer(Team team){
        Row[] rows = getTeamThisRound().getMyLastCell().getRows();
        for (int i = 0; i < rows.length; i++) {
            if(!rows[i].getNumGuess().getText().toString().equals(rows[i].getNumAnswer().getText().toString())) return false;
        }
        return true;
    }


    public Result chooseNumCodeInCell(int index , int number){
        if(index<0 || index>2) return new Result(false , "index is out of bound");
        if(number<1 || number>4) return new Result(false , "your numCodes is invalid");

        getTeamThisRound().getMyLastCell().getRows()[index].setStringNumGuess(number);
        return new Result(true , "your numCodes has set successfully");
    }

    public Result typeGuessWordInColumn(int index,String guess){
        if(index<0 || index>3) return new Result(false , "index is out of bound");
        if(!Util.isMatchStringWithRegex(guess ,"[A-Za-z ]+")) return new Result(false ,"your input is invalid");

       // getTeamThisRound().getColumns()[index].getCodes().add(guess);
        return new Result(true, "word inserted successfully");
    }
//
//    public Result processGameOver(){
//
//    }

    public int[] getNewNumCode(){
        return numCodes;
    }

    private void generateAndSetNumCode(){
       ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        for (Integer number : numbers) {
            int random = Util.getRandom().nextInt() % 4;
            Util.swapObjectInArrayList(numbers , numbers.indexOf(number) , random );
        }

        for (int i = 0; i < numCodes.length; i++) {
            numCodes[i] = numbers.get(i);
        }
    }
}
