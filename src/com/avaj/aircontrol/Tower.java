package com.avaj.aircontrol;

import com.avaj.interfaces.Flyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){ observers.remove(flyable); }

    protected void conditionsChanged(){
        for (Flyable o : observers){
            o.updateConditions();
        }
    }
}
