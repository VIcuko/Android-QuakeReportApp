package com.example.android.quakereport;

/**
 * Created by Vicuko on 2/8/17.
 */

public class Earthquake {
    double mMagnitude;
    String mLocation;
    String mDate;

    public Earthquake(double magnitude, String location, String date){
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

    public String getDate(){
        return mDate;
    }

}
