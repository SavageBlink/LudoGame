package com.company;

import java.util.ArrayList;


public class Case {

    ArrayList<Horse> content;

    public Case() {
        this.content = new ArrayList<Horse>();
    }

    public ArrayList<Horse> getContent(){
        return this.content;
    }

    public void addHorse(Horse juan){
        if(this.content.size() < 2){
            this.content.add(juan);
        }else {
            System.err.println("# Size-type error in : addHorse #");
            System.err.println("# Juan just got into two new friends #");
        }
    }

    public void yeetHorse(Horse juan){
        this.content.remove(juan);
    }

    public int getSize(){
        return this.content.size();
    }

}
