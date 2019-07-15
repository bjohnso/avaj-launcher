package com.avaj;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable o : observers){
            o.updateConditions();
        }
    }
}
