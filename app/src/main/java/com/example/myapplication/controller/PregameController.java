package com.example.myapplication.controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;

import com.example.myapplication.model.Team;
import com.example.myapplication.utlls.Result;
import com.example.myapplication.utlls.Util;

import java.util.ArrayList;

public class PregameController {
    private boolean isTeam1Turn = true;
    private GameController gameController = new GameController();

    public void setTeamName(String name){
        getTeamThisTurn().setName(name);
    }

    public boolean isTeam1Turn() {
        return isTeam1Turn;
    }
    public void changeTurn() {
        if (isTeam1Turn) isTeam1Turn = false;
        else isTeam1Turn = true;
    }
//    public Result startGame(){
//
//    }

    public Team getTeamThisTurn(){
        if(isTeam1Turn) return gameController.getTeam1();
        else return gameController.getTeam2();
    }

    public Result setWord(String[] words){
       // if(index <0 || index >3 ) return new Result(false , "index is out of bound!");

        getTeamThisTurn().setWords(words);
        return new Result(true , "set word successfully");
    }

    public Result setTimeEveryRound(int time){
        if(time < 0) return new Result(false , "time can not be less than 0 !");

        gameController.setRoundTime(time);
        return new Result(true, "time of each round set successfully");
    }

    public Result setRoundNumber(int round){
        if(round < 0) return new Result(false , "round can not be less than 1 !");

        gameController.setRoundNumber(round);
        return new Result(true , "number of rounds set successfully");
    }

    public Result setPlayersList(ArrayList<String> players){

        getTeamThisTurn().setPlayers(players);
        return new Result(true , "this player added successfully");
    }

    public Result gameStart(Intent intent){

        return new Result(true , "game start");
    }

    public Result removePlayer(int index){
        ArrayList<String> players = getTeamThisTurn().getPlayers();
        if(index <0 || index>players.size()-1) return new Result(false , "index is out of bound!");

        players.remove(index);
        return new Result(true , "player from players removed successfully");
    }


}
