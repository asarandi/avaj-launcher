package com._42;

import java.util.ArrayList;
import java.util.List;

abstract class Tower {
    private List <Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable f){
        observers.add(f);
    }

    public void unregister(Flyable f){
        observers.remove(f);
    }

    protected void conditionsChanged(){
        for (Flyable f : observers) {
            f.updateConditions();
        }
    }
}