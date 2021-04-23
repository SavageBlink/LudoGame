package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private static final ArrayList<Player> players = generatePlayers();
    public  static final ArrayList<Tile> tiles = generateTiles();
    private Dice d;



    public Board(){ this.d = new Dice(); }

    public Board(int nbFaces){
        this.d = new Dice(nbFaces);
    }

    private static ArrayList<Tile> generateTiles(){
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

    public Tile getTiles(int index){
        if(index >= 0 && index < 52){
            return tiles.get(index);
        }else {
            System.err.println("# Size-type error in getCase method (Board class) #");
            return null;
        }
    }

    public Player getPlayer(Color color){
        Player out = getPlayers().get(0);
        switch (color){
            case RED -> out = getPlayers().get(0);
            case BLUE -> out = getPlayers().get(1);
            case YELLOW -> out = getPlayers().get(2);
            case GREEN -> out = getPlayers().get(3);
        }return  out;
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
        int nextTilePos = (h.getAbsolutePosition() + dr < 52 ) ? h.getAbsolutePosition() + dr : h.getAbsolutePosition() + dr - 52;
        boolean result = true;
        if(currentTile.getNumberOfHorseOfColor(h.getColor()) == 1 || (currentTile.getNumberOfHorseOfColor(h.getColor()) > 1 && dr % 2 != 0)){
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
        Tile currentTile = getTiles(h.getAbsolutePosition());

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
        Tile currentTile = getTiles(h.getAbsolutePosition());
        int nextTilePos;
        Tile nextTile;

        nextTilePos = (h.getAbsolutePosition() + dr < 52 ) ? h.getAbsolutePosition() + dr : h.getAbsolutePosition() + dr - 52;
        nextTile = getTiles(nextTilePos);

        nextTile.addHorse(h);
        currentTile.yeetHorse(h);
        h.setAbsolutePosition(nextTilePos);
        h.addStep(dr);

        nextTile.clearContent(h.getColor());
    }

    public void moveHorse(Horse h, int dr) {
        if (h.getAbsolutePosition() == -1){ //Checking if the horse hasn't been out yet
            int startingTileIndex = getPlayer(h.getColor()).getHomeTile();
            Tile startingTile = getTiles(startingTileIndex);
            startingTile.addHorse(h);
            h.setAbsolutePosition(startingTileIndex);
            h.setRelativePosition(0);
        }else { //Otherwise move it normally
            Tile currentTile = getTiles(h.getAbsolutePosition());

            if (currentTile.getNumberOfHorseOfColor(h.getColor()) > 1) {
                translateBlock(h, dr);
            } else {
                translateHorse(h, dr);
            }
        }

    }

    public void turn(Player player,int dr) {
        System.out.println("It's "+ player.getColor() + " Turn");
        int diceResult = getD().roll();
        System.out.println("You rolled a " + diceResult);
        ArrayList <Horse> playableHorse = player.getPlayableHorses(this.d,diceResult);
        System.out.println("Vous pouvez ainsi jouer :");


        if(playableHorse.size() != 0) {
            int n = 0;
            //play the user turn
            for (Horse h : playableHorse) {
                System.out.println(n);
                System.out.println(h.toString());
                n++;
            }
            Scanner sc = new Scanner(System.in);

            String input = sc.nextLine();
            int id = Integer.parseInt(input);

            moveHorse(playableHorse.get(id), diceResult);
        }else{
            System.out.println("You have no horse to move, passing turn");
        }
        //TODO userSelection

        //if()
    }

    public void gameLoop(){
        ArrayList<Player> winOrder = new ArrayList<>();
        while (winOrder.size() != 3){
            for (Player player : getPlayers()){
                int dR = getD().getNbFaces();
                while (dR == getD().getNbFaces() && !player.isFinished()){
                    dR = getD().roll();
                    turn(player, dR);
                }
                if (!winOrder.contains(player) && player.isFinished()){
                    winOrder.add(player);
                }
            }
        }

        System.out.println("The game is finshed here's the result : ");
        for (Player p : winOrder){
            System.out.println(p.getColor());
        }






    } //TODO

}
