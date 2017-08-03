package com.example.android.quakereport;

/**
 * Created by Vicuko on 2/8/17.
 */

public class Earthquake {
    double mMagnitude;
    String mLocation;
    long mDate;
    String mUrl;

    public Earthquake(double magnitude, String location, long date, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
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

    public String getUrl(){
        return mUrl;
    }

}
