package com.lab.catclicker;

public class CreditInfo {
    String name, link;
    int img;
    public CreditInfo(String name, String link, int img){
        this.name = name;
        this.link = link;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public int getImg() {
        return img;
    }
}
