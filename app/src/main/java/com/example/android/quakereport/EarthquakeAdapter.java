package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.support.v4.content.ContextCompat.getColor;

/**
 * Created by Vicuko on 2/8/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakeArray) {
        super(context, 0, earthquakeArray);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Earthquake earthquake = getItem(position);

        TextView magnitude = (TextView) listView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(earthquake.getMagnitude());
        magnitude.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        TextView distance = (TextView) listView.findViewById(R.id.distance);
        TextView location = (TextView) listView.findViewById(R.id.location);
        ArrayList<String> locationStrings = formatLocation(earthquake.getLocation());
        distance.setText(locationStrings.get(0));
        location.setText(locationStrings.get(1));

        TextView date = (TextView) listView.findViewById(R.id.date);
        String formattedDate = formatDate(earthquake.getDate());
        date.setText(formattedDate);

        TextView time = (TextView) listView.findViewById(R.id.time);
        String formattedTime = formatTime(earthquake.getDate());
        time.setText(formattedTime);

        return listView;
    }

    private String formatDate(long date){
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String dateToDisplay = dateFormat.format(date);
        return dateToDisplay;
    }

    private String formatMagnitude (double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String newMagnitude = formatter.format(magnitude);
        return newMagnitude;
    }

    private int getMagnitudeColor (double magnitude){
        int roundedMagnitude = (int) magnitude;
        int magnitudeColor;
        switch (roundedMagnitude){
            case 1:
                magnitudeColor = getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
        return magnitudeColor;
    }

    private ArrayList<String> formatLocation(String locationText){
        ArrayList<String> newLocation = new ArrayList<String>();
        String separator = getContext().getString(R.string.separator);
        int divisorPosition = locationText.indexOf(separator);
        String distance="";
        String location="";
        if (divisorPosition>0){
            distance = locationText.substring(0,divisorPosition + separator.length() + 1);
            location = locationText.substring(divisorPosition);
        }
        else{
            distance = getContext().getString(R.string.location_initial_string);
            location = locationText;
        }
        newLocation.add(distance);
        newLocation.add(location);

        return newLocation;
    }

    private String formatTime(long date){
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = dateFormat.format(date);
        return timeToDisplay;
    }
}
