package com.avaj.aircraft;

import com.avaj.map.Coordinates;

public class Aircraft {

    protected long mId;
    protected String mName;
    protected Coordinates mCoordinates;
    private long mIdCounter;

    public Aircraft(){

    }

    protected Aircraft(String name, Coordinates coordinates){
        mName = name;
        mCoordinates = coordinates;
    }

    private long nextId(){
        return mIdCounter++;
    }
}
