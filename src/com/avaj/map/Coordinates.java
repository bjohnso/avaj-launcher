package com.avaj.map;

public class Coordinates {

    private int mLongitude;
    private int mLatitude;
    private int mHeight;

    public Coordinates(int longitude, int latitude, int height){
        mLongitude = longitude;
        mLatitude = latitude;
        mHeight = height;
        if (mLongitude < 0)
            mLongitude = 0;
        if (mLatitude < 0)
            mLatitude = 0;
        if (mHeight < 0)
           mHeight = 0;
        else if (mHeight > 100)
            mHeight = 100;
    }

    public int getLongitude() {
        return this.mLongitude;
    }

    public int getLatitude() {
        return this.mLatitude;
    }

    public int getHeight(){
        return this.mHeight;
    }

    public void mutateLongitude(int longitude){
        mLongitude+=longitude;
        if (mLongitude < 0)
            mLongitude = 0;
    }

    public void mutateLatitude(int latitude){
        mLatitude+=latitude;
        if (mLatitude < 0)
            mLatitude = 0;
    }

    public void mutateHeight(int height){
        mHeight+=height;
        if (mHeight < 0)
            mHeight = 0;
        else if (mHeight > 100)
            mHeight = 100;
    }

    @Override
    public String toString() {
        return mLatitude + " lat/" + mLongitude + " long/" + mHeight + " height";
    }
}
