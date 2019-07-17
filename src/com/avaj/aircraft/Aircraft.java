package com.avaj.aircraft;

import com.avaj.map.Coordinates;

public class Aircraft {

    protected long mId;
    protected String mName;
    protected String mType;
    protected Coordinates mCoordinates;
    private long mIdCounter = 0;

    public Aircraft(){

    }

    protected Aircraft(String name, String type, Coordinates coordinates){
        mName = name;
        mType = type;
        mCoordinates = coordinates;
        mId = nextId();
    }

    private long nextId(){
        return mIdCounter++;
    }

    public String getName(){
        return mName;
    }

    public String getType() {
        return mType;
    }

    public Coordinates getCoordinates() {
        return mCoordinates;
    }

    public long getId(){
        return mId;
    }
}
