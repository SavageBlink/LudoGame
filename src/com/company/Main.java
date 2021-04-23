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

        Player blocker = GameBoard.getPlayer(Color.BLUE);
        Player redPlayer = GameBoard.getPlayer(Color.RED);
        Horse juan1 = blocker.getLhorse().get(0);
        Horse juan2 = blocker.getLhorse().get(1);
        Horse redHorse = redPlayer.getLhorse().get(1);
        Tile blockTile = GameBoard.getTiles(1);
        Tile zeroTile = GameBoard.getTiles(0);

        redHorse.setAbsolutePosition(0);
        redHorse.setRelativePosition(0);
        juan1.setAbsolutePosition(1);
        juan2.setAbsolutePosition(1);
        blockTile.addHorse(juan1);
        blockTile.addHorse(juan2);
        zeroTile.addHorse(redHorse);


        GameBoard.gameLoop();
    }
}
