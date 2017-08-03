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

        TextView location = (TextView) listView.findViewById(R.id.location);
        location.setText(earthquake.getLocation());

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
}
