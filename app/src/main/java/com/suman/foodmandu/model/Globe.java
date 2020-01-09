package com.suman.foodmandu.model;

public class Globe {

    private int gimage;
    private String gTitle;
    private String gCountry;
    private String gAddress;

    public Globe(int gimage, String gTitle, String gCountry, String gAddress) {
        this.gimage = gimage;
        this.gTitle = gTitle;
        this.gCountry = gCountry;
        this.gAddress = gAddress;
    }

    public int getGimage() {
        return gimage;
    }

    public void setGimage(int gimage) {
        this.gimage = gimage;
    }

    public String getgTitle() {
        return gTitle;
    }

    public void setgTitle(String gTitle) {
        this.gTitle = gTitle;
    }

    public String getgCountry() {
        return gCountry;
    }

    public void setgCountry(String gCountry) {
        this.gCountry = gCountry;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }
}
