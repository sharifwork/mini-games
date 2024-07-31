package com.example.myapplication.utlls;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.view.ImagesResource;

import java.util.ArrayList;

public class AdderPlayer {
    private ImageView imageView ;
    private boolean isAddState ;
    private View number ;
    private EditText playerName;
    private static ArrayList<AdderPlayer> adderPlayers = new ArrayList<>();

    public AdderPlayer( ImageView imageView  , EditText playerName , View number) {
        this.number = number;
        this.playerName = playerName;
        this.imageView = imageView;
        adderPlayers.add(this);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public boolean isAddState() {
        return isAddState;
    }

    public void setAddState(boolean addState) {
        isAddState = addState;
    }

    public View getNumber() {
        return number;
    }

    public void setNumber(View number) {
        this.number = number;
    }

    public TextView getPlayerName() {
        return playerName;
    }

    public void setPlayerName(EditText playerName) {
        this.playerName = playerName;
    }

    public void add(){
        isAddState = false;
        imageView.setImageResource(ImagesResource.REMOVE.getImg());
         number.setVisibility(View.VISIBLE);
         playerName.setVisibility(View.VISIBLE);
    }

    public void remove(){
        isAddState = true;
        imageView.setImageResource(ImagesResource.ADD.getImg());
        number.setVisibility(View.INVISIBLE);
        playerName.setVisibility(View.INVISIBLE);
        playerName.setText("");
    }

    public static AdderPlayer getAdderPlayerByImageView(View imageView){
        for (AdderPlayer adderPlayer : adderPlayers) {
            if(adderPlayer.imageView == (ImageView) imageView ) return adderPlayer;
        }
        return null;
    }

    public static void clear(){
        for (AdderPlayer adderPlayer : adderPlayers) {
            adderPlayer.playerName.setText("");

            if(adderPlayers.indexOf(adderPlayer)==0){
                adderPlayer.setAddState(false);
                adderPlayer.imageView.setImageResource(ImagesResource.REMOVE.getImg());
                adderPlayer.imageView.setVisibility(View.VISIBLE);
                adderPlayer.playerName.setVisibility(View.VISIBLE);
                adderPlayer.number.setVisibility(View.VISIBLE);
            }
            else if(adderPlayers.indexOf(adderPlayer)==1){
                adderPlayer.setAddState(true);
                adderPlayer.imageView.setImageResource(ImagesResource.ADD.getImg());
                adderPlayer.imageView.setVisibility(View.VISIBLE);
                adderPlayer.number.setVisibility(View.INVISIBLE);
                adderPlayer.playerName.setVisibility(View.INVISIBLE);
            }
            else {
                adderPlayer.playerName.setVisibility(View.INVISIBLE);
                adderPlayer.number.setVisibility(View.INVISIBLE);
                adderPlayer.imageView.setVisibility(View.INVISIBLE);
            }



        }
    }
}
