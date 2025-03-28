package com.lab.catclicker;

public class Upgrades {

    String name, dis, pricename;
    int image, price;
    public Upgrades(String name, String dis,String pricename, int image,int price){
        this.name = name;
        this.dis = dis;
        this.image = image;
        this.pricename = pricename;
        this.price = price;
    }
    public String getName(){
        return name;
    }

    public String getDis() {
        return dis;
    }
    public int getImage(){
        return image;
    }
    public String getPrice(){
        return pricename;
    }
    public int getPriceValue(){
        return price;
    }
    public void setPriceValue(double mult){
        this.price *=mult;
    }
}
