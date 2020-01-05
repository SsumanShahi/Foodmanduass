package com.suman.foodmandu.model;

public class Details {
    private String RTitle;
    private String Address;
    private String Group;
    private String DeliveryHour;
    private int image;

    public Details(String RTitle, String address, String group, String deliveryHour, int image) {
        this.RTitle = RTitle;
        Address = address;
        Group = group;
        DeliveryHour = deliveryHour;
        this.image = image;
    }

    public String getRTitle() {
        return RTitle;
    }

    public void setRTitle(String RTitle) {
        this.RTitle = RTitle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getDeliveryHour() {
        return DeliveryHour;
    }

    public void setDeliveryHour(String deliveryHour) {
        DeliveryHour = deliveryHour;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
