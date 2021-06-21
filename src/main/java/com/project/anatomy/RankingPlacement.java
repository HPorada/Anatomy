package com.project.anatomy;

//klasa pomocnicza do tworzenia rankingu
public class RankingPlacement {

    String username;
    int points;

    public RankingPlacement(String username, int points) {
        this.username = username;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
