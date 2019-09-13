package com.example.reviewandroid;

public class TechNamePic {

    public String getTech_name() {
        return tech_name;
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
    }

    private String tech_name;
    private int tech_pic;

    public TechNamePic(String tech_name, int pic){
        this.tech_name = tech_name;
        this.tech_pic = pic;
    }

    public int getPic() {
        return tech_pic;
    }

    public void setPic(int pic) {
        this.tech_pic = pic;
    }

    }
