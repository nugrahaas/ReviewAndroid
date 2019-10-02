package com.example.reviewandroid.Category;

public class OtomotifNamePic {

    public String getOtomotif_name() {
        return otomotif_name;
    }

    public void setOtomotif_name(String otomotif_name) {
        this.otomotif_name = otomotif_name;
    }

    private String otomotif_name;
    private int otomotif_pic;

    public OtomotifNamePic(String otomotif_name, int pic){
        this.otomotif_name = otomotif_name;
        this.otomotif_pic = pic;
    }

    public int getPic() {
        return otomotif_pic;
    }

    public void setPic(int pic) {
        this.otomotif_pic = pic;
    }

    }
