package com.suman.foodmandu.model;

public class Special {

    private int simage;
    private String stitle;

    public Special(int simage, String stitle) {
        this.simage = simage;
        this.stitle = stitle;
    }

    public int getSimage() {
        return simage;
    }

    public void setSimage(int simage) {
        this.simage = simage;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }
}
