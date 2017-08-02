package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        date.setText(earthquake.getDate());

        return listView;
    }
}
