package com.suman.foodmandu.model;

public class Restaurant {

    private String rname;
    private String rlocation;
    private String rimage;

    public Restaurant(String rname, String rlocation, String rimage) {
        this.rname = rname;
        this.rlocation = rlocation;
        this.rimage = rimage;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRlocation() {
        return rlocation;
    }

    public void setRlocation(String rlocation) {
        this.rlocation = rlocation;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }
}
