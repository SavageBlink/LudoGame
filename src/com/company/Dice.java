package com.company;

public class Dice {
    int nbFaces;

    public Dice(){
        this.nbFaces = 6;
    }

    public Dice(int nbFaces){
        this.nbFaces = nbFaces;
    }

    public int getNbFaces() {
        return nbFaces;
    }

    public void setNbFaces(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int roll(){
        int r = (int) (Math.random()*nbFaces) + 1;
        return r;
    }
}
