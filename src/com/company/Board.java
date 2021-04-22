package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private static final ArrayList<Player> players = generatePlayers();
    public  static final ArrayList<Tile> tiles = generateCases();
    private Dice d;



    public Board(){ this.d = new Dice(); }

    public Board(int nbFaces){
        this.d = new Dice(nbFaces);
    }

    private static ArrayList<Tile> generateCases(){
        ArrayList<Tile> tiles = new ArrayList<>();
        for(int i = 0;i<52;i++){
            tiles.add(new Tile());
        }
        // setting safe tiles
        tiles.get(0).setSafe(true);
        tiles.get(8).setSafe(true);
        tiles.get(13).setSafe(true);
        tiles.get(21).setSafe(true);
        tiles.get(26).setSafe(true);
        tiles.get(34).setSafe(true);
        tiles.get(39).setSafe(true);
        tiles.get(47).setSafe(true);

        return tiles;
    }

    private static ArrayList<Player> generatePlayers(){
        ArrayList<Player> players = new ArrayList<>();
        for (Color c: Color.values()) {
            players.add(new Player(c));
        }
        return players;
    }

    //getter
    public Dice getD() {
        return d;
    }

    public ArrayList<Player> getPlayers(){return players;}

    public Tile getCase(int index){
        if(index >= 0 && index < 52){
            return tiles.get(index);
        }else {
            System.err.println("# Size-type error in getCase method (Board class) #");
            return null;
        }
    }



    //setter

    public void setD(Dice d) {
        this.d = d;
    }

    //Game logic


    public static boolean freePath(Horse h, int dr){
        if (h.getAbsolutePosition() == -1){
            return  false;
        }
        //the block case is basically handled because according to the rules it can always move on a tile
        Tile currentTile = tiles.get(h.getAbsolutePosition());
        int nextTilePos = h.getAbsolutePosition() + dr;
        boolean result = true;

        if(currentTile.getNumberOfHorseOfColor(h.getColor()) == 1){
            for(int i = h.getAbsolutePosition()+1; i <= nextTilePos; i++){
                Tile temporaryTile = tiles.get(i);
                if(temporaryTile.isThereBlock()){
                    result = false;
                }
            }
        }
        return result;
    }

    public void translateBlock(Horse h,int dr){
        //Initialisation
        Tile currentTile = tiles.get(h.getAbsolutePosition());

        int modDr = (dr % 2 == 0) ? dr / 2 : dr;
        this.translateHorse(h,modDr);
        if(dr % 2 == 0){
            for (Horse tempHorse : currentTile.getContent()){
                if(tempHorse.getColor() == h.getColor()){
                    this.translateHorse(tempHorse,modDr);
                    break;
                }
            }
        }
    }

    public void translateHorse(Horse h,int dr){
        Tile currentTile = tiles.get(h.getAbsolutePosition());
        int nextTilePos;
        Tile nextTile;

        nextTilePos = h.getAbsolutePosition() + dr;
        nextTile = tiles.get(nextTilePos);

        nextTile.addHorse(h);
        currentTile.yeetHorse(h);
        h.setAbsolutePosition(nextTilePos);
        h.addStep(dr);

        nextTile.clearContent(h.getColor());
    }

    public void moveHorse(Horse h, int dr) {
        Tile currentTile = tiles.get(h.getAbsolutePosition());

        if(currentTile.getNumberOfHorseOfColor(h.getColor()) > 1){
            translateBlock(h,dr);
        }else{
            translateHorse(h,dr);
        }


    }

    public void turn(Player player) {
        System.out.println("It's "+ player.getColor() + " Turn");
        int diceResult = 6;
        System.out.println("You rolled a " + diceResult);
        ArrayList <Horse> playableHorse = player.getPlayableHorses(this.d,diceResult);
        System.out.println("Vous pouvez ainsi jouer :");
        int n = 0;
        for (Horse h : playableHorse){

            System.out.println(n);
            System.out.println(h.toString());
            n++;
        }

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();

        System.out.println(id);

        //TODO userSelection

        //if()
    }

    //public void Gameloop{return} //TODO
}
