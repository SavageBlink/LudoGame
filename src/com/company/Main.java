package com.company;



public class Main {

    public static void main(String[] args) {
        Board GameBoard = new Board(6);


        for(Player p : GameBoard.getPlayers()){
            Horse juan2 = p.getLhorse().get(0);
            Tile tile = GameBoard.getTiles(p.getHomeTile());
            tile.addHorse(juan2);
            juan2.setAbsolutePosition(p.getHomeTile());
            juan2.setRelativePosition(0);
        }

        for(int i = 0; i<11;i++){
            for (Player kevin : GameBoard.getPlayers()) {
                System.out.println(kevin);
                GameBoard.turn(kevin);
            }
        }
    }
}
