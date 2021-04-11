package com.company;



public class Main {

    public static void main(String[] args) {
        Board Gameboad = new Board(8);
    /**
        System.out.println(Gameboad.getBlue().getColor());
        System.out.println(Gameboad.getBlue().getHomeCase());
        Gameboad.getBlue().getPawns().get(0).addStep(5);
        for (Horse id : Gameboad.getBlue().getPawns()){
            System.out.println(id.getRelativePosition());
        }

        System.out.println(Gameboad.getRed().getColor());
        System.out.println(Gameboad.getRed().getHomeCase());

        for (Horse id : Gameboad.getRed().getPawns()){
            System.out.println(id.getRelativePosition());
        }

        System.out.println(Gameboad.getGreen().getColor());
        System.out.println(Gameboad.getGreen().getHomeCase());

        for (Horse id : Gameboad.getGreen().getPawns()){
            System.out.println(id.getRelativePosition());
        }

        System.out.println(Gameboad.getYellow().getColor());
        System.out.println(Gameboad.getYellow().getHomeCase());

        for (Horse id : Gameboad.getYellow().getPawns()){
            System.out.println(id.getRelativePosition());
        }
        **/
        for (int i = 0; i<5;i++) {
            int temp = Gameboad.getD().roll();
            System.out.println(temp);
        }

        Horse test = new Horse(Color.BLUE,-1,2);

        System.out.println(test);
    }
}
