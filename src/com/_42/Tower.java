package com._42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class Tower {
    private ArrayList <Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable f){
        observers.add(f);
    }

    public void unregister(Flyable f){
        observers.remove(f);
    }

    protected void conditionsChanged(){

        for (Flyable f : observers) {
            Flyable banana = f;
            banana.updateConditions();
        }

//        for (int i=0; i<observers.size(); i++) {
//            Flyable f = observers.get(i);
//            f.updateConditions();
//        }
    }
}