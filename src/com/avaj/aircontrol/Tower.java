package com.avaj.aircontrol;

import com.avaj.aircraft.Aircraft;
import com.avaj.interfaces.Flyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Aircraft aircraft){
        if (observers.contains(aircraft))
            return;
        observers.add((Flyable)aircraft);
        System.out.println(aircraft.getType() + "#"
                + aircraft.getName()
                + "(" + aircraft.getId() + ") : REGISTERED TO WEATHERTOWER");
    }

    public void unregister(Aircraft aircraft){
        observers.remove(aircraft);
        System.out.println(aircraft.getType() + "#"
                + aircraft.getName()
                + "(" + aircraft.getId() + ") : UNREGISTERED TO WEATHERTOWER");
    }

    protected void conditionsChanged(){
        for (int i = 0 ; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
