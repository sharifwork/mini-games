package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.controller.PregameController;

public class PreGameActivity extends AppCompatActivity {

    private EditText teamName;
    private EditText[] words;
    private ImageView[] addPlayers;
    private EditText[] playersName;
    private PregameController controller = new PregameController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pre_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initializeView(){
        teamName = findViewById(R.id.teamName);
        words = new EditText[4];
        words[0] = findViewById(R.id.word1);
        words[1] = findViewById(R.id.word2);
        words[2] = findViewById(R.id.word3);
        words[3] = findViewById(R.id.word4);
        addPlayers = new ImageView[4];
        addPlayers[0] = findViewById(R.id.addPlayer1);
        addPlayers[1] = findViewById(R.id.addPlayer2);
        addPlayers[2] = findViewById(R.id.addPlayer3);
        addPlayers[3] = findViewById(R.id.addPlayer4);
        playersName = new EditText[4];
        playersName[0] = findViewById(R.id.player1);
        playersName[1] = findViewById(R.id.player2);
        playersName[2] = findViewById(R.id.player3);
        playersName[3] = findViewById(R.id.player4);
    }

    public void clickSubmit(View view){
        String[] words = new String[4];
        for (int i = 0; i < words.length; i++) {
            words[i] = this.words[i].getText().toString();
        }
    }
}