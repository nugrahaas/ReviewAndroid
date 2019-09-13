package com.example.reviewandroid;

public class DapurNamePic {

    public String getDapur_name() {
        return dapur_name;
    }

    public void setDapur_name(String dapur_name) {
        this.dapur_name = dapur_name;
    }

    private String dapur_name;
    private int dapur_pic;

    public DapurNamePic(String dapur_name, int pic){
        this.dapur_name = dapur_name;
        this.dapur_pic = pic;
    }

    public int getPic() {
        return dapur_pic;
    }

    public void setPic(int pic) {
        this.dapur_pic = pic;
    }

    }
