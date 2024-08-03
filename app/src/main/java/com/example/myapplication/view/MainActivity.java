package com.example.myapplication.view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Dialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

private EditText editText;
private TextView textView;
private  Dialog dialogWriter;
private Dialog dialogShow;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dialogShow = new Dialog(this);
        dialogShow.setContentView(R.layout.show_pupup);
        dialogShow.setTitle("سلام حسن");

        dialogWriter = new Dialog(this);
        dialogWriter.setContentView(R.layout.write_pupup);
        dialogWriter.setTitle("سلام حسن");

    }

    public void clickButtonStartGame(View view){
        Intent intent = new Intent(MainActivity.this, PreGameActivity.class);
        startActivity(intent);
    }

    public void clickButtonHistoryGame(View view){

        showEditDialog();
//        Intent intent = new Intent(MainActivity.this, DoozActivity.class);
//        startActivity(intent);
    }

    private void showEditDialog() {
        showCustomDialog();
    }

    private void showCustomDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomDialog);
        dialogBuilder.setView(R.layout.show_pupup);
        AlertDialog dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.shape);
        dialog.show();
    }

    public void clickReturnButton(View view){
        dialogWriter.dismiss();
    }

    public void clickButtonPlayPupup(View view){
        dialogShow.dismiss();
        dialogWriter.show();
    }

}
