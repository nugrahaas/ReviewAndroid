package com.example.reviewandroid;

public class Genre {

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    private String genre_name;
    private int pic;

    public Genre(String genre_name, int pic){
        this.genre_name = genre_name;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    }
