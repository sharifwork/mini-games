package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DoozActivity extends AppCompatActivity {

    private char [] board = new char[9];
    private boolean isOTurn = false;
    private Random random = new Random();
    private char turn = '#';
    private int scoreO = 0;
    private int scoreX = 0;
    private TextView score_X;
    private TextView score_O;
    private int img_X;
    private int img_O;
    private int img_blank;
    private Handler handler = new Handler();
    private View viewGame ;
    private boolean clickable = true;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dooz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dooz), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        score_X = findViewById(R.id.score_X);
        score_O = findViewById(R.id.score_O);
        img_X = R.drawable.x;
        img_O = R.drawable.o;
        img_blank = R.drawable.blank;
        viewGame = findViewById(R.id.dooz);

        isOTurn = random.nextBoolean();
        for (int i = 0; i < board.length; i++) {
            board[i] = '#';
        }

        changeColorBG();
    }

    public void clickOnCell(View view){
        if(!clickable) return;

        int index = Integer.parseInt((String) view.getTag());

        if(board[index] != '#') return;

        if(isOTurn) turn = 'O';
        else turn = 'X' ;

        board[index] = turn;
        if(isOTurn) ((ImageView)view).setImageResource(img_O);
        else ((ImageView)view).setImageResource(img_X);

        if(checkWinner() || checkBoardFull()) {
            if(checkWinner()){
                if(isOTurn) {
                    scoreO++;
                    score_O.setText(""+scoreO);
                }
                else{
                    scoreX++;
                    score_X.setText("" + scoreX);
                }
            }
            clickable = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickable = true;
                    clearBoard();
                }
            }, 3000);
        }

        changeTurn();

    }

    public boolean checkBoardFull(){
        for (char cell : board) {
            if(cell == '#') return false;
        }
        return true;
    }

    public void changeTurn(){
        if(isOTurn) isOTurn = false;
        else isOTurn = true;
        changeColorBG();
    }
    private void changeColorBG(){
        if(isOTurn) ((ConstraintLayout)viewGame).setBackgroundColor(Color.parseColor("#03A9F4"));
        else ((ConstraintLayout)viewGame).setBackgroundColor(Color.parseColor("#FA5D52"));
    }

    private void clearBoard(){
        for (int i = 0; i < ((ConstraintLayout)viewGame).getChildCount(); i++) {
          if(((ConstraintLayout)viewGame).getChildAt(i) instanceof ImageView
                  && Integer.parseInt((String)((ConstraintLayout)viewGame).getChildAt(i).getTag()) != 40
                  && Integer.parseInt((String)((ConstraintLayout)viewGame).getChildAt(i).getTag()) != 41 )

              ((ImageView)((ConstraintLayout)viewGame).getChildAt(i)).setImageResource(img_blank);
        }

        for (int i = 0; i < board.length; i++) {
            board[i] = '#';
        }

//        ((ImageView)findViewById(R.id.cell0)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell1)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell2)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell3)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell4)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell5)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell6)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell7)).setImageResource(img_blank);
//        ((ImageView)findViewById(R.id.cell8)).setImageResource(img_blank);
    }

    public boolean checkWinner(){
        int [][] winState  = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int i = 0; i < winState.length ; i++) {
            if(checkWinState(winState[i])) return true;
        }
        return false;
    }

    private boolean checkWinState(int[] winState){

        if(board[winState[0]] == turn && board[winState[1]]== turn && board[winState[2]] == turn)
            return true;
        return false;
    }
}