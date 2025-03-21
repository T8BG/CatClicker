package com.lab.catclicker;

public class Upgrades {

    String name, dis;
    int image;
    public Upgrades(String name, String dis,int image){
        this.name = name;
        this.dis = dis;
        this.image = image;
    }
    public String getName(){
        return name;
    }

    public String getDis() {
        return dis;
    }
}
