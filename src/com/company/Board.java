package com.company;


import java.util.ArrayList;

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

        players.add(new Player(Color.RED));
        players.add(new Player(Color.BLUE));
        players.add(new Player(Color.YELLOW));
        players.add(new Player(Color.RED));

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

    //Gamelogic

    public static void clearTile(Tile t){
        for(Horse juan : t.getContent()){
            t.yeetHorse(juan);
            juan.setAbsolutePosition(-1);
        }
    }

    public static boolean freePath(Horse h, int dr){

        Tile currentTile = tiles.get(h.getAbsolutePosition());
        int nextTilePos = h.getAbsolutePosition() + dr;
        Tile nextTile = tiles.get(nextTilePos);
        boolean result = true;

        if(currentTile.getSize() == 1){
            for(int i = h.getAbsolutePosition()+1; i <= h.getAbsolutePosition() + dr; i++){
                Tile temporaryTile = tiles.get(i);
                Horse h1 = temporaryTile.getContent().get(0);
                Horse h2 = temporaryTile.getContent().get(1);
                if(temporaryTile.getSize() == 2 && (h1.getColor() != h2.getColor())){
                    result = false;
                }
            }
        }
        return result;
    }

    /*

    nextTilePos = (dr%2 == 0) ? dr/2 : dr;
       moving pieces
    if(dr%2 == 0){

                clearTile(nextTile);

                for (Horse juan : currentTile.getContent()){
                    nextTile.addHorse(juan);
                    currentTile.yeetHorse(juan);
                    juan.setAbsolutePosition(nextTilePos);
                }
            }else {

            }
     */

    public void turn(Player player) {
        System.out.println("It's "+ player.getColor() + " Turn");
        int diceResult = d.roll();
        System.out.println("You rolled a" + diceResult);
        ArrayList <Horse> playableHorse = player.getPlayableHorses(this.d,diceResult);
        System.out.println("Vous pouvez ainsi jouer :");

        for (Horse h : playableHorse){
            h.toString();
        }


        //TODO userSelection

        //if()
    }

    //public void Gameloop{return} //TODO
}
