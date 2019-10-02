package com.example.reviewandroid.Category;

public class MenuNamePic {


    private String menu_name;
    private int menu_pic;


    public MenuNamePic(String menu_name, int menu_pic) {
        this.menu_name = menu_name;
        this.menu_pic = menu_pic;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getMenu_pic() {
        return menu_pic;
    }

    public void setMenu_pic(int menu_pic) {
        this.menu_pic = menu_pic;
    }
}