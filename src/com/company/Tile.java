package com.company;

import java.util.ArrayList;


public class Tile {

    private ArrayList<Horse> content;
    private boolean safe;

    public Tile() {
        this.safe = false;
        this.content = new ArrayList<Horse>();
    }

    public ArrayList<Horse> getContent(){
        return this.content;
    }

    public void addHorse(Horse juan){
            this.content.add(juan);
            juan.setSafe(this.safe);
    }

    public void yeetHorse(Horse juan){
        this.content.remove(juan);
    }

    public void clearContent(Color color){
        if(!this.isSafe()){
            for(Horse juan : this.content){
                if(juan.getColor() != color){
                    this.yeetHorse(juan);
                }
            }
        }
    }

    public int getSize(){
        return this.content.size();
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isSafe(){
        return this.safe;
    }

    public String toString(){
        String output ="the tile is safe ?\n" + this.safe +"\n";
        for (Horse h : this.content){
             output += h.toString();
        }
        return output;
    }

    public int getNumberOfHorseOfColor(Color color){
        int i = 0;
        for (Horse h : this.getContent()){
            i = (h.getColor() == color) ? i+1 : i ;
        }return  i;
    }

}
