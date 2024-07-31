package com.example.myapplication.view;

import androidx.annotation.DrawableRes;

import com.example.myapplication.R;

public enum ImagesResource {
    REMOVE(R.drawable.x)
    ,ADD(R.drawable.o);


    @DrawableRes private int img ;

    ImagesResource(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
