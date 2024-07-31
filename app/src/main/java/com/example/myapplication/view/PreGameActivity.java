package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.controller.PregameController;
import com.example.myapplication.utlls.AdderPlayer;

import java.util.ArrayList;

public class PreGameActivity extends AppCompatActivity {

    private EditText teamName;
    private EditText[] words;
    private ArrayList<AdderPlayer> addPlayersList;
    private PregameController controller = new PregameController();
    private int time;
    private int round;
    private int endIndexAddPlayers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pre_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pregame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeView();

    }

    public void initializeView(){
        teamName = findViewById(R.id.teamName);
        words = new EditText[4];
        words[0] = findViewById(R.id.word1);
        words[1] = findViewById(R.id.word2);
        words[2] = findViewById(R.id.word3);
        words[3] = findViewById(R.id.word4);

        addPlayersList = new ArrayList<>();
        AdderPlayer adderPlayer1 = new AdderPlayer(findViewById(R.id.addPlayer1) , findViewById(R.id.player1) , findViewById(R.id.num1));
        adderPlayer1.setAddState(false);
        addPlayersList.add(adderPlayer1) ;

        AdderPlayer adderPlayer2 = new AdderPlayer(findViewById(R.id.addPlayer2), findViewById(R.id.player2) , findViewById(R.id.num2));
        adderPlayer2.setAddState(true);
        addPlayersList.add(adderPlayer2) ;

        addPlayersList.add(new AdderPlayer(findViewById(R.id.addPlayer3), findViewById(R.id.player3) , findViewById(R.id.num3))) ;
        addPlayersList.add(new AdderPlayer(findViewById(R.id.addPlayer4), findViewById(R.id.player4) , findViewById(R.id.num4))) ;

        teamName.setText("team1");

    }

    public void clickHandler(){

    }
    public void clickSubmit(View view) {
        String teamName = this.teamName.getText().toString();
//        if (teamName.equals("")) {
//            Toast.makeText(this, "team name is empty", Toast.LENGTH_SHORT).show();
//        }
        if(teamName.equals("")){
            if(controller.isTeam1Turn()) teamName = "team1";
            else teamName = "team2";
        }
        controller.setTeamName(teamName);

        String[] words = new String[4];
        for (int i = 0; i < words.length; i++) {
            words[i] = this.words[i].getText().toString();
            if (words[i].equals("")) {
                Toast.makeText(this, "word is empty", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        controller.setWord(words);

        ArrayList<String> players = new ArrayList<>();
        for (AdderPlayer adderPlayer : addPlayersList) {
            String name = adderPlayer.getPlayerName().getText().toString();
            if(!name.equals(""))
                players.add(name);
        }

        if (players.size() < 2) {
            Toast.makeText(this, "number of players is less than 2", Toast.LENGTH_SHORT).show();
            return;
        }

        controller.setPlayersList(players);
        controller.setRoundNumber(round);
        controller.setTimeEveryRound(time);

        if(controller.isTeam1Turn()){
            controller.changeTurn();
            endIndexAddPlayers = 0;
            clearParameters();
            ((ImageView)view).setImageResource(ImagesResource.RUN.getImg());
        }
        else{
            Intent intent = new Intent(PreGameActivity.this, GameActivity.class);
            startActivity(intent);
            controller.gameStart(intent);
        }
    }

    public void clearParameters(){


        for (EditText word : words) {
            word.setText("");
        }

        AdderPlayer.clear();

        if(!controller.isTeam1Turn()){
            teamName.setText("team2");
            View radioGroups = findViewById(R.id.layoutRadioGroups);
            radioGroups.setVisibility(View.INVISIBLE);
        }
    }

    public void clickTimePerRound(View view){
        switch (Integer.parseInt((String)view.getTag())){
            case 1:
                time = 60;
                break;
            case 2:
                time = 90;
                break;
            case 3:
                time = 120;
                break;
        }
    }

    public void clickNumRound(View view){
        switch (Integer.parseInt((String)view.getTag())){
            case 1:
                round = 4;
                break;
            case 2:
                round = 5;
                break;
            case 3:
                round = 6;
                break;
        }
    }

    public void clickAdderPlayer(View view){
        AdderPlayer adderPlayer = AdderPlayer.getAdderPlayerByImageView(view);
        if(adderPlayer.equals(null)) return;

        if(adderPlayer.isAddState()){
            if(!AdderPlayer.checkPreviousTextFieldNoEmpty(endIndexAddPlayers)){
                Toast.makeText(this, "player name is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            endIndexAddPlayers = addPlayersList.indexOf(adderPlayer);
            adderPlayer.addAction();
            if(endIndexAddPlayers != addPlayersList.size()-1){
                addPlayersList.get(endIndexAddPlayers +1).setAddState(true);
                addPlayersList.get(endIndexAddPlayers +1).getImageView().setImageResource(ImagesResource.ADD.getImg());
                addPlayersList.get(endIndexAddPlayers +1).getImageView().setVisibility(View.VISIBLE);
            }

        }
        else{

            int indexAdderPlayer = addPlayersList.indexOf(adderPlayer);
            for (int i = indexAdderPlayer+1 ; i < addPlayersList.size(); i++) {
                (addPlayersList.get(i-1).getPlayerName()).setText((addPlayersList.get(i).getPlayerName()).getText());
            }
            addPlayersList.get(endIndexAddPlayers).removeAction();
            if(endIndexAddPlayers<addPlayersList.size()-1){
                addPlayersList.get(endIndexAddPlayers+1).getImageView().setVisibility(View.INVISIBLE);
            }
            if(endIndexAddPlayers !=0) endIndexAddPlayers--;

        }
    }

}