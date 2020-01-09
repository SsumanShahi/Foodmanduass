package com.suman.foodmandu.model;

public class Details {
    private String image;
    private String itemtype;
    private String name;
    private String location;

    public Details(String image, String itemtype, String name, String location) {
        this.image = image;
        this.itemtype = itemtype;
        this.name = name;
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
