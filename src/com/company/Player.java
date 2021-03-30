package com.company;

import java.util.ArrayList;

public class Player {
    Color color;
    ArrayList<Horse> pawns = new ArrayList<Horse>();
    int homeCase;

    public Player(Color color){
        this.color = color;
        for(int i = 0;i < 4;i++){
            Horse current = new Horse(this.color,-1,i);
            pawns.add(current);
        }

        switch (this.color){
            case RED -> this.homeCase = 0;
            case BLUE -> this.homeCase = 13;
            case YELLOW -> this.homeCase = 26;
            case GREEN ->  this.homeCase = 39;
        }
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Horse> getPawns() {
        return pawns;
    }

    public int getHomeCase() {
        return homeCase;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHomeCase(int homeCase) {
        this.homeCase = homeCase;
    }

    private void setPawns(ArrayList<Horse> pawns) {
        this.pawns = pawns;
    }
}
