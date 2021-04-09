package com.company;

public class Block {
    private Horse bot;
    private Horse top;

    public Block(Horse top, Horse bot){
        this.top = top;
        this.bot = bot;
    }

    public Horse getTop() {
        return top;
    }

    public Horse getBot() {
        return bot;
    }

}
