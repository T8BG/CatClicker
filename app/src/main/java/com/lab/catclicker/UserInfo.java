package com.lab.catclicker;

public class UserInfo {
    String username, password;
    static int points;
    static int totalPoints;
    static int health = 100;
    static int thoughts = 0;
    static int howHungry = 0;

    static int itemAQuantity = 0; // Point upgrade One
    static int itemBQuantity = 0; // Point upgrade Two
    static int itemCQuantity = 0; // Point upgrade Three

    static boolean auto = false;

    static int clickValue = 1;

    public UserInfo(){
        this.username = "user";
        this.password = "user";
        this.points = 0;
        this.health = 100;
        this.auto = false;
        this.thoughts = 0;
    }
    public UserInfo(String username,String password){
        this.username = username;
        this.password = password;
        this.points = 0;
        this.health = 0;
        this.auto = false;
        this.thoughts = 0;
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

    public static void setPoints() {
        points += clickValue;
        //totalPoints += points;
    }
    public static void addMult()
    {
        if(itemAQuantity <=3) {
            clickValue = clickValue * 2;
            itemAQuantity++;
        }
    }
    public static int getItemAQuantity(int price){return price*(int)Math.pow(2,itemAQuantity);}
    public static int getItemBQuantity(int price){return price*(int)Math.pow(3,itemBQuantity);}
    public static int getItemCQuantity(int price){return price*(int)Math.pow(3,itemCQuantity);}
    public static int getThoughtsPrice(){return (int) Math.pow(5, thoughts);}
    public static void addBigMult(){
        if(itemBQuantity <= 3)
        {
            clickValue = clickValue * 5;
            itemBQuantity++;
        }
    }
    public static void addNiceMult(){
        if(itemCQuantity <= 3)
        {
            clickValue = clickValue * 4;
            itemCQuantity++;
        }
    }
    public static void payTheBills(int point){
        points -= point;
    }
    public static int getMult(){
        return clickValue;
    }

    public static void lowerHealth()
    {
        health--;
    }

    public static void Healthy(){
        health += 5;
        howHungry +=1;
    }
    public static int getHowHungry(int price){return price*(int)Math.pow(2,howHungry);}
    public static int getHealth()
    {
        return health;
    }

    public static int getPoints() {
        return points;
    }
    public static int getTotalPoints()
    {
        return totalPoints;
    }
    public static void autoBuy(){auto = true;}
    public static int getAutoBuy(int price){
        if(isAutoActive()){
            price *=100;
        }
        return price;
    }
    public static boolean isAutoActive(){
        return  auto;
    }
    public static void theThinker(){
        thoughts += 1;
    }
    public static int getThoughts(){
        return thoughts;
    }
}