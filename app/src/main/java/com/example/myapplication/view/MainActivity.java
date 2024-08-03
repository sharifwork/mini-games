package com.example.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.DoozActivity;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

private EditText editText;
private TextView textView;
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
        // ایجاد دیالوگ
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_pupup);
        dialog.setTitle("Edit Text");

        dialog.show(); // نمایش دیالوگ
    }


}
