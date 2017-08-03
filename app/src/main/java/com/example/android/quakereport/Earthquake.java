package com.example.android.quakereport;

/**
 * Created by Vicuko on 2/8/17.
 */

public class Earthquake {
    double mMagnitude;
    String mLocation;
    long mDate;

    public Earthquake(double magnitude, String location, long date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getDate(){
        return mDate;
    }

}
