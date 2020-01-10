package com.suman.foodmandu.model;

public class Sweet {

    private String swname;
    private String swtype;
    private String swimage;

    public Sweet(String swname, String swtype, String swimage) {
        this.swname = swname;
        this.swtype = swtype;
        this.swimage = swimage;
    }

    public String getSwname() {
        return swname;
    }

    public void setSwname(String swname) {
        this.swname = swname;
    }

    public String getSwtype() {
        return swtype;
    }

    public void setSwtype(String swtype) {
        this.swtype = swtype;
    }

    public String getSwimage() {
        return swimage;
    }

    public void setSwimage(String swimage) {
        this.swimage = swimage;
    }
}
