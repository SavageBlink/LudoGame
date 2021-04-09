package com.company;

import java.util.ArrayList;

public class Player {
    private Color color;
    private ArrayList<Horse> pawns = new ArrayList<>();
    private ArrayList<Block> blocks = new ArrayList<>();
    private int homeCase;

    public Player(Color color){
        this.color = color;
        for(int i = 0;i < 4;i++){
            Horse current = new Horse(this.color,-1,i);
            pawns.add(current);
        }
        this.homeCase = identifyHomeCase(color);
    }

    public static int identifyHomeCase(Color color) {
        int out = -1;
        switch (color){
            case RED -> out = 0;
            case BLUE -> out = 13;
            case YELLOW -> out = 26;
            case GREEN ->  out = 39;
        }
        return out;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Horse> getPawns() {
        return pawns;
    }

    public int getHomeCase() {
        return homeCase;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHomeCase(int homeCase) {
        this.homeCase = homeCase;
    }

    private void setPawns(ArrayList<Horse> pawns) {
        this.pawns = pawns;
    }

    public void movePawn(Horse h, int steps){
        if(h.isSafe()){
            h.flipSafe();
        }
        h.addStep(steps);
    }

    public void checkSafePosition(Horse h){ //Supposed to be lunched after each horse movement TODO blockthinggy?
        for(int i = 0;i<4;i++){
            if(Board.starsPosition[i] == h.getRelativePosition() + this.homeCase || h.relativePosition == 0){
                h.flipSafe();
                return;
            }
        }
    }

    public ArrayList<Horse> getPlayablePawns(Dice d){ //TODO BLOCK THINGGY
        ArrayList<Horse> result = new ArrayList<>();
        int dr = d.roll();
        for (Horse h: this.getPawns()){
            if ((h.relativePosition == -1 && dr == d.nbFaces ) || Board.freePath(h,dr)){
                result.add(h);
            }
        }return result;
    }
}
