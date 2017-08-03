package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        magnitude.setText(Double.toString(earthquake.getMagnitude()));

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

    private String formatTime(long date){
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = dateFormat.format(date);
        return timeToDisplay;
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
}
