package com.example.android.quakereport;

/**
 * Created by Vicuko on 3/8/17.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {
    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link Earthquake} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Earthquake> extractEarthquakes() {

        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        try {
            JSONObject jsonObj = new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONArray features = jsonObj.getJSONArray("features");

            for (int i = 0; i < features.length(); i++){
                JSONObject earthquake_info = features.getJSONObject(i);
                JSONObject properties = earthquake_info.getJSONObject("properties");

                double magnitude = properties.getDouble("mag");
                String location = properties.getString("place");
                long date = properties.getLong("time");

                String url = properties.getString("url");

                Earthquake earthquake = new Earthquake(magnitude, location, date, url);
                earthquakes.add(earthquake);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return earthquakes;
    }

}