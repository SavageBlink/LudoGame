package com.company;

import java.util.ArrayList;

public class Player {
    private Color color;
    private final ArrayList<Horse> Lhorse = new ArrayList<>();
    private final int homeTile;
    private boolean finished;

    public Player(Color color){
        this.color = color;
        for(int i = 0;i < 4;i++){
            Horse current = new Horse(this.color,-1,-1,i);
            Lhorse.add(current);
        }
        this.homeTile = identifyHomeTile(color);
        this.finished = false;
    }

    //Getter

    public Color getColor() {
        return color;
    }

    public ArrayList<Horse> getLhorse() {
        return Lhorse;
    }

    public int getHomeTile() {
        return homeTile;
    }

    public ArrayList<Horse> getPlayableHorses(Dice d, int dr){ //TODO BLOCK THINGGY
        ArrayList<Horse> result = new ArrayList<>();
        for (Horse h: this.getLhorse()){
            if ( (h.getRelativePosition() == -1 && dr == d.getNbFaces()) || Board.freePath(h,dr)){
                result.add(h);
            }
        }return result;
    }

    //Check if the player has put all his Horse on it's finishing tile
    public boolean isFinished(){
        if (!this.finished){
            this.finished = true;
            for (Horse juan : this.getLhorse()){
                if(juan.getAbsolutePosition() != 56){
                    this.finished = false;
                }
            }
        }
        return this.finished;
    }

    //Setter
    public void setColor(Color color) {
        this.color = color;
    }
    //Modifier
    public void moveHorse(Horse h, int steps){
        h.addStep(steps);
    }



    public static int identifyHomeTile(Color color) {
        int out = -1;
        switch (color){
            case RED -> out = 0;
            case BLUE -> out = 13;
            case YELLOW -> out = 26;
            case GREEN ->  out = 39;
        }
        return out;
    }


    public String toString(){
        String output = "";
        output+= "This is the " + this.color + " Player\n";
        output+= "It's home tile is " + this.homeTile + " Player\n";
        output+= "Here's a display of it's Horses : \n";
        for(Horse juan : this.Lhorse){
            output+= juan.toString();
        }
        return output;
    }

}
