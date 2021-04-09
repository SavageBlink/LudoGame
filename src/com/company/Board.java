package com.company;


import java.util.ArrayList;

public class Board {
    private ArrayList<Player> players = new ArrayList<>();
    public static int[] starsPosition = {8,21,34,47};


    private Dice d;

    public Board(){
        this.players.add(new Player(Color.RED));
        this.players.add(new Player(Color.BLUE));
        this.players.add(new Player(Color.YELLOW));
        this.players.add(new Player(Color.RED));
        this.d = new Dice();
    }

    public Board(int nbFaces){
        this.players.add(new Player(Color.RED));
        this.players.add(new Player(Color.BLUE));
        this.players.add(new Player(Color.YELLOW));
        this.players.add(new Player(Color.RED));
        this.d = new Dice(nbFaces);
    }

    //getter
    public Dice getD() {
        return d;
    }

    public ArrayList<Player> getPlayers(){return players;}

    //setter

    public void setD(Dice d) {
        this.d = d;
    }

    public static boolean freePath(Horse h, int dr){

        return true; //TODO
    }

    public void turn(Player player) {
        int diceResult = d.roll();
    }

    //public void Gameloop{return} //TODO
}
