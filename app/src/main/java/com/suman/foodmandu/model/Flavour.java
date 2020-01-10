package com.suman.foodmandu.model;

public class Flavour {

    private String fname;
    private String fprice;
    private String fimage;

    public Flavour(String fname, String fprice, String fimage) {
        this.fname = fname;
        this.fprice = fprice;
        this.fimage = fimage;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }
}
