package com.example.myapplication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.controller.GameController;
import com.example.myapplication.model.Cell;
import com.example.myapplication.model.Column;
import com.example.myapplication.model.Row;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private static GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.game), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controller.gameSetup();
        initializeView();
      //  controller.getTeamThisRound().getCells().get(1).getRows()[2].setStringCode("اینجام");
        for (Cell cell : controller.getTeamThisRound().getCells()) {
            cell.getScore().setText("+2");
            cell.getAuthor().setText("محمد");
            for (Row row : cell.getRows()) {
                for (int i = 0; i < 3; i++) {
                    row.getTextByIndex(i).setText("A");
                }

            }
        }

        for (Cell cell : controller.getTeamThisRound().getEnemyCells()) {
            cell.getScore().setText("+2");
            cell.getAuthor().setText("علی");
            for (Row row : cell.getRows()) {
                for (int i = 0; i < 3; i++) {
                    row.getTextByIndex(i).setText("C");
                }

            }
        }

        for (Column column : controller.getTeamThisRound().getColumns()) {
            for (int i = 0; i < 8; i++) {
                column.getTextByIndex(i).setText("B");
            }
        }
    }

    public void initializeView(){
        ((TextView)findViewById(R.id.teamnameTitle)).setText(controller.getTeamThisRound().getName().getText().toString());
        ((TextView)findViewById(R.id.word1Title)).setText(controller.getTeamThisRound().getWords()[0].getText().toString());
        ((TextView)findViewById(R.id.word2Title)).setText(controller.getTeamThisRound().getWords()[1].getText().toString());
        ((TextView)findViewById(R.id.word3Title)).setText(controller.getTeamThisRound().getWords()[2].getText().toString());
        ((TextView)findViewById(R.id.word4Title)).setText(controller.getTeamThisRound().getWords()[3].getText().toString());

        for (int i = 0; i < controller.getTeamThisRound().getCells().size(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3 ; k++) {
                    int resID = getResources().getIdentifier("text_" + 1 + i + j + k, "id", getPackageName());
                    if(j == 3){
                        if(k==0) controller.getTeamThisRound().getCells().get(i).setAuthor(findViewById(resID));
                        else if(k == 1) controller.getTeamThisRound().getCells().get(i).setScore(findViewById(resID));
                        continue;
                    }
                    controller.getTeamThisRound().getCells().get(i).getRows()[j].setTextByIndex(k , findViewById(resID));
                }
            }
        }

        for (int i = 0; i < controller.getTeamThisRound().getEnemyCells().size(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3 ; k++) {
                    int resID = getResources().getIdentifier("text_" + 2 + i + j + k, "id", getPackageName());
                    if(j == 3){
                        if(k==0) controller.getTeamThisRound().getEnemyCells().get(i).setAuthor(findViewById(resID));
                        else if(k == 1) controller.getTeamThisRound().getEnemyCells().get(i).setScore(findViewById(resID));
                        continue;
                    }
                    controller.getTeamThisRound().getEnemyCells().get(i).getRows()[j].setTextByIndex(k , findViewById(resID));
                }
            }
        }

        for (int i = 0; i < controller.getTeamThisRound().getColumns().length; i++) {
            for (int j = 0; j < 8 ; j++) {
                int resID = getResources().getIdentifier("text_" + 3 + i + j, "id", getPackageName());
                controller.getTeamThisRound().getColumns()[i].setTextByIndex(j , findViewById(resID));
            }
        }
    }

    private View getViewsByTag(String tag){
        switch (tag.charAt(0)){
            case '1':
                return getViewInCellsByTag(controller.getTeamThisRound().getCells(),tag);
            case '2':
                return getViewInCellsByTag(controller.getTeamThisRound().getEnemyCells(), tag);
            case '3':
                if(tag.charAt(2)=='6')
                    return controller.getTeamThisRound().getColumns()[tag.charAt(1)-'0'].getGuess();
                if(tag.charAt(2)=='7')
                    return controller.getTeamThisRound().getColumns()[tag.charAt(1)-'0'].getAnswer();

                return controller.getTeamThisRound().getColumns()[tag.charAt(1)-'0'].getCodes().get(tag.charAt(2)-'0');
        }
        return null;
    }

    private View getViewInCellsByTag(ArrayList<Cell> cells,String tag){
        if(tag.charAt(2)=='3'){
            if(tag.charAt(3)=='0')
                return cells.get(tag.charAt(1)-'0').getAuthor();
            if(tag.charAt(3)=='1')
                return cells.get(tag.charAt(1)-'0').getScore();
        }
        if(tag.charAt(3)=='0')
            return cells.get(tag.charAt(1)-'0').getRows()[tag.charAt(2)-'0'].getCode();
        if(tag.charAt(3)=='1')
            return cells.get(tag.charAt(1)-'0').getRows()[tag.charAt(2)-'0'].getNumGuess();
        if(tag.charAt(3)=='2')
            return cells.get(tag.charAt(1)-'0').getRows()[tag.charAt(2)-'0'].getNumAnswer();
        return null;
    }

    public static void setGameController(GameController gameController) {
        GameActivity.controller = gameController;
    }

}