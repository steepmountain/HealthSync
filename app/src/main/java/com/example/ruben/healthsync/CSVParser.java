package com.example.ruben.healthsync;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ruben on 25.02.2017.
 */

public class CSVParser {

    // returns an array-list of runs. The first items is always a header
    public ArrayList<Exercise> parse(File toParse) throws IOException {

        Log.v("Name of file to parse", toParse.getName());

        // Turns the input file into an InputStream
        InputStream is = new FileInputStream(toParse);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        ArrayList<Exercise> exerciseArray = new ArrayList<>();

        String lineText = null;
        int lineNumber = 0;

        // one run per line in the CSV file
        while ((lineText = reader.readLine()) != null) {

            // Line 0 = header
            // Line 1 = titles
            if (lineNumber > 0) {

                String[] row = lineText.split(",");

                String endTime = row[1];    // date in format YYYY-MM-DD
                String startTime = row[4];  // date in format YYYY-MM-DD
                String duration = row[8];   // Time in miliseconds
                String maxHeartRate = row[10]; // bpm
                String meanHeartRate = row[12]; // bpm
                String maxCadence = row[14];
                String exerciseType = row[18]; // 1001 for findCSV, 1002 for run
                String maxSpeed = row[19]; // *3.59~ for km/h
                String caloriesBurned = row[23];
                String meanSpeed = row[25]; // *3.59~ for km/h
                String meanCadence = row[24];
                String minHeartRate = row[28]; // bpm
                String distance = row[33]; // distance in meters
                String createTime = row[36]; // creation time for CSV;

                // TODO: Print out all row names with i to compare, a lot the indexis are wrong
                for (int i = 0; i < row.length; i++) {
                    Log.v("Indexis", "Row=" + row[i] + " : Index=" + i);
                }


                Exercise e = new Exercise(endTime, startTime, duration, maxHeartRate, meanHeartRate, maxCadence,
                        exerciseType, maxSpeed, caloriesBurned, meanSpeed, meanCadence,
                        minHeartRate, distance, createTime);
                exerciseArray.add(e);
            }
            lineNumber++;


        }

        return exerciseArray;
    }
}
