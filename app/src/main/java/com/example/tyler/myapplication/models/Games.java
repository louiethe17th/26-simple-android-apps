package com.example.tyler.myapplication.models;

import android.graphics.drawable.Drawable;


public class Games {

    public String title;
    public int drawableId;
    public String rating;
    public String genre;
    public String description;

    public Games(String title, int drawableId, String rating, String genre, String description){
        this.title = title;
        this.drawableId = drawableId;
        this.rating = rating;
        this.genre = genre;
        this.description = description;
    }
}
