package com.avaj.aircontrol;

import com.avaj.Main;
import com.avaj.aircraft.Aircraft;
import com.avaj.interfaces.Flyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Aircraft aircraft){
        if (observers.contains(aircraft))
            return;
        observers.add((Flyable)aircraft);
        Main.writer.println(aircraft.getType() + "#"
                + aircraft.getName()
                + "(" + aircraft.getId() + ") : REGISTERED TO WEATHERTOWER AT COORDINATES " + aircraft.getCoordinates());
    }

    public void unregister(Aircraft aircraft){
        observers.remove(aircraft);
        Main.writer.println(aircraft.getType() + "#"
                + aircraft.getName()
                + "(" + aircraft.getId() + ") : UNREGISTERED TO WEATHERTOWER AT COORDINATES " + aircraft.getCoordinates());
    }

    protected void conditionsChanged(){
        for (int i = 0 ; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
