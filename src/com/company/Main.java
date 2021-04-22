package com.company;



public class Main {

    public static void main(String[] args) {
        Board Gameboard = new Board(6);

        Player player = Gameboard.getPlayers().get(0);

        Horse juan = Gameboard.getPlayers().get(0).getLhorse().get(0);
        Horse juan2 = Gameboard.getPlayers().get(0).getLhorse().get(2);

        Tile brazil = Gameboard.getCase(0);
        brazil.addHorse(juan);
        brazil.addHorse(juan2);
        System.out.println(brazil);



        System.out.println("###################\n");

        for (Player kevin: Gameboard.getPlayers()) {
            System.out.println(kevin);
        }
         Gameboard.turn(player);

    }
}
