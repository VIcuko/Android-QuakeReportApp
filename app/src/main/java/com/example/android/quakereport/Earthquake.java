package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Vicuko on 2/8/17.
 */

public class Earthquake {
    int mMagnitude;
    String mLocation;
    Date mDate;

    public Earthquake(int magnitude, String location, Date date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public int getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public Date getDate(){
        return mDate;
    }
}
