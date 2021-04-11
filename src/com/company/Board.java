package com.company;


import java.util.ArrayList;

public class Board {
    private static final ArrayList<Player> players = generatePlayers();
    public  static final ArrayList<Case> cases = generateCases();
    public static int[] starsPosition = {8,21,34,47};


    private Dice d;

    public Board(){
        this.d = new Dice();
    }

    public Board(int nbFaces){
        this.d = new Dice(nbFaces);
    }

    //getter
    public Dice getD() {
        return d;
    }

    public ArrayList<Player> getPlayers(){return players;}

    public Case getCase(int index){
        if(index >= 0 && index < 52){
            return cases.get(index);
        }else {
            System.err.println("# Size-type error in getCase method (Board class) #");
            return null;
        }
    }

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

    private static ArrayList<Case> generateCases(){
        ArrayList<Case> cases = new ArrayList<>();
        for(int i = 0;i<52;i++){
            cases.add(new Case());
        }
        return cases;
    }

    private static ArrayList<Player> generatePlayers(){
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(Color.RED));
        players.add(new Player(Color.BLUE));
        players.add(new Player(Color.YELLOW));
        players.add(new Player(Color.RED));

        return players;
    }
    //public void Gameloop{return} //TODO
}
