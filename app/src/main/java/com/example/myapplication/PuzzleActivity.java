package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleActivity extends AppCompatActivity {


    private View emptyView;
    private ArrayList<ViewToImage> images = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private View viewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.puzzle), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}
//        emptyView = findViewById(R.id.imageView0);
//        mediaPlayer = MediaPlayer.create(this , R.raw.hassan);
//        viewGame = findViewById(R.id.puzzle);
//
//        initilizeImageViews();
//        randomize();




//    public void initilizeImageViews(){

//        int j =0;
//        for (int i = 0; i < ((ConstraintLayout)viewGame).getChildCount(); i++) {
//            if (((ConstraintLayout)viewGame).getChildAt(i) instanceof ImageView)
//                images.add( Integer.parseInt((String) ((ConstraintLayout)viewGame).getChildAt(j).getTag()), new ViewToImage(((ConstraintLayout)viewGame).getChildAt(j) , getImageRecourse(j++)));
//        }

//        images.add( new ViewToImage(findViewById(R.id.imageView0), getImageRecourse(0))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView1) , getImageRecourse(1)));
//        images.add( new ViewToImage(findViewById(R.id.imageView2), getImageRecourse(2))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView3), getImageRecourse(3))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView4), getImageRecourse(4))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView5), getImageRecourse(5))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView6), getImageRecourse(6))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView7), getImageRecourse(7))) ;
//        images.add( new ViewToImage(findViewById(R.id.imageView8), getImageRecourse(8))) ;
//
//    }
//
//    public void clickCell(View view){
//
//        int indexButton = Integer.parseInt((String)view.getTag());
//        if(!checkButtonSideEmpty(indexButton-1)) return;
//        swapImageByView(emptyView , view);
//        emptyView = view;
//
//        if(checkGameOver()) {
//            Toast.makeText(this, "آفرین", Toast.LENGTH_SHORT).show();
//            mediaPlayer.start();
//
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                   randomize();
//                }
//            }, 3000);
//        }
//
//    }
//
//    public boolean checkButtonSideEmpty(int indexButton){
//        int indexEmpty = Integer.parseInt((String)emptyView.getTag()) - 1;
//        int rowButton = indexButton/3;
//        int colButton = indexButton%3;
//        int rowEmpty = indexEmpty/3;
//        int colEmpty = indexEmpty%3;
//        if(Math.abs(rowButton - rowEmpty) + Math.abs(colButton - colEmpty) == 1){
//            return true;
//        }
//        return false;
//    }
//
//    public void clickReturn(View view){
//        randomize();
//    }
//
//    public void swapImageByView(View view1 , View view2){
//
//        Integer tmp = getView(view1).imgSRC;
//        getView(view1).imgSRC = getView(view2).imgSRC;
//        getView(view2).imgSRC = tmp;
//
//        ((ImageView)view1).setImageResource(getView(view1).imgSRC);
//        ((ImageView)view2).setImageResource(getView(view2).imgSRC);
//
//    }
//
//    public void randomize(){
//        ArrayList<Integer> randomList = new ArrayList<>();
//        for (ViewToImage image : images) {
//            randomList.add(image.imgSRC);
//        }
//        Collections.shuffle(randomList);
//
//        int i=0;
//        for (ViewToImage image : images) {
//            if(randomList.get(i).equals( getImageRecourse(0) )) emptyView = image.view;
//            image.imgSRC = randomList.get(i);
//            ((ImageView) image.view).setImageResource(randomList.get(i++));
//        }
//
//    }
//
//
//
//    public Integer getImageRecourse(int index){
//        switch (index){
//            case 1:
//                return R.drawable.n1;
//            case 2:
//                return R.drawable.n2;
//            case 3:
//                return R.drawable.n3;
//            case 4:
//                return R.drawable.n4;
//            case 5:
//                return R.drawable.n5;
//            case 6:
//                return R.drawable.n6;
//            case 7:
//                return R.drawable.n7;
//            case 8:
//                return R.drawable.n8;
//            default:
//                return R.drawable.n0;
//
//        }
//    }
//
//    public boolean checkGameOver(){
//        int i=0;
//        for (ViewToImage image : images) {
//            if(!image.imgSRC.equals(getImageRecourse(i++))){
//                Log.d("hasan" , String.valueOf(i-1));
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public <E> ViewToImage getView ( E object) {
//
//        for (ViewToImage image : images) {
//            if(image.view.equals(object) || image.imgSRC.equals(object)){
//                return image;
//            }
//        }
//        return null;
//    }
//}