package com.suman.foodmandu.model;

public class Alchohol {

    private String aname;
    private String aquantity;
    private String aprice;
    private String aimage;

    public Alchohol(String aname, String aquantity, String aprice, String aimage) {
        this.aname = aname;
        this.aquantity = aquantity;
        this.aprice = aprice;
        this.aimage = aimage;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAquantity() {
        return aquantity;
    }

    public void setAquantity(String aquantity) {
        this.aquantity = aquantity;
    }

    public String getAprice() {
        return aprice;
    }

    public void setAprice(String aprice) {
        this.aprice = aprice;
    }

    public String getAimage() {
        return aimage;
    }

    public void setAimage(String aimage) {
        this.aimage = aimage;
    }
}
