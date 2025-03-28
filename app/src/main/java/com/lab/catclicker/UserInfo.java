package com.lab.catclicker;

public class UserInfo {
    String username, password;
    static int points;

    static int itemAQuantity = 1; // Point upgrade One
    static int itemBQuantity; // Point upgrade Two
    static int itemCQuantity; // Point upgrade Three

    static int clickValue = 1;

    public UserInfo(){
        this.username = "user";
        this.password = "user";
        this.points = 0;
    }
    public UserInfo(String username,String password){
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static int setPoints() {
        points += clickValue;
        return points;
    }
    public static int addPoints(){

        if(itemAQuantity!=0)
        {
            clickValue += 1;
        }
        if(itemBQuantity!=0)
        {
            clickValue += 2;
        }
        if(itemCQuantity!=0)
        {
            clickValue += 3;
        }

        return clickValue;
    }

    public static int getPoints() {

        return points;
    }
}
