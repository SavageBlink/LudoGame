package com.company;

public class Horse {

    Color color;
    int relativePosition; // from -1 to 51,52-55, -1 : home, 52-55 : arrow
    int id;
    boolean safe;

    public Horse(Color color,int relativePosition,int id){
        this.color = color;
        this.relativePosition = relativePosition;
        this.safe = false;
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public int getRelativePosition() {
        return relativePosition;
    }

    public boolean isSafe() {
        return safe;
    }

    public int getId() {
        return id;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setRelativePosition(int relativePosition){
        this.relativePosition = relativePosition;
    }

    public void flipSafe(){
        this.safe = !safe;
    }

}
