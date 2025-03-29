package com.lab.catclicker;

public class Upgrades {

    String name, dis;
    int image, price;
    public Upgrades(String name, String dis, int image,int price){
        this.name = name;
        this.dis = dis;
        this.image = image;

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

    public int getPriceValue(){
        return price;
    }
    public boolean checkers(){
        if(UserInfo.getPoints() >= this.price){
            return true;
        }
        return false;
    }
    public int priceIsPricier(){
        return price *=3; //test
    }

}
