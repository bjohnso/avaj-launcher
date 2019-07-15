package com.avaj;

public class Coordinates {

    private int mLongitude;
    private int mLatitude;
    private int mHeight;

    public Coordinates(int longitude, int latitude, int height){
        mLongitude = longitude;
        mLatitude = latitude;
        mHeight = height;
    }

    public int getLongitude() {
        return mLongitude;
    }

    public int getLatitude() {
        return mLatitude;
    }

    public int getHeight(){
        return mHeight;
    }
}
