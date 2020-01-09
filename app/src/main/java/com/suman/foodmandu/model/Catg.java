package com.suman.foodmandu.model;

public class Catg {

    private int cimage;
    private String ctitle;

    public Catg(int cimage, String ctitle) {
        this.cimage = cimage;
        this.ctitle = ctitle;
    }

    public int getCimage() {
        return cimage;
    }

    public void setCimage(int cimage) {
        this.cimage = cimage;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }
}
