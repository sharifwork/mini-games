package com.example.myapplication.view;

import androidx.annotation.DrawableRes;

import com.example.myapplication.R;

public enum ImagesResource {
    REMOVE(R.drawable.remove)
    ,ADD(R.drawable.add)
    ,RUN(R.drawable.run);


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
