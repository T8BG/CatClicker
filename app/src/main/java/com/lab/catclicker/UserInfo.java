package com.lab.catclicker;

public class UserInfo {
    String username, password;
    int points;
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

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
