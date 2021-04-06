package com.company;


public class Board {

    Player red;
    Player blue;
    Player yellow;
    Player green;

    public static int[] starsPosition = {8,21,34,47};


    Dice d;

    public Board(){
        this.red = new Player(Color.RED);
        this.blue = new Player(Color.BLUE);
        this.yellow = new Player(Color.YELLOW);
        this.green = new Player(Color.GREEN);
    }

    //getter
    public Dice getD() {
        return d;
    }

    public Player getBlue() {
        return blue;
    }

    public Player getGreen() {
        return green;
    }

    public Player getRed() {
        return red;
    }

    public Player getYellow() {
        return yellow;
    }

    //setter

    public void setD(Dice d) {
        this.d = d;
    }



}
