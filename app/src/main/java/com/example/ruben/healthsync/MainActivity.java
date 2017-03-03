package com.example.ruben.healthsync;

// Looks through expected folders to find exported CSVs from Samsung Health S
// Take the newest file and send it to CSVParser
// Turn the CSVParser's array into JSON objects and send to database
// TODO: Make Comparator to properly Collections.Sort runs, move into FileWalker?
// TODO: Make runs into JSON objects and send them to database;
// TOOD: Fix error message

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String FOLDER = "/storage/emulated/0/SHealth/";
    private static final int REQUEST_CODE_PERMISSION = 2;
    String errorMsg = "";
    TextView textViewError;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewError = (TextView) findViewById(R.id.textViewError);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        // Checks and requests permissions to read external SD storage
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSION);
        }

        // looks through the file system for csv files
        FileWalker fw = new FileWalker();
        File csv = fw.findCSV(FOLDER);
        CSVParser parser = new CSVParser();

        // tries to parse the CSV and handles errors
        try {
            String output = "";
            // Gets last member of list
            ArrayList<Exercise> runList = parser.parse(csv);

            Log.v("RunListSize", runList.size() + "");

            for (int i = 1; i < runList.size(); i++) {
                Exercise e = runList.get(i);
                output += i + ". " + e.toString() + "\n \n";
            }
            textViewOutput.setText(output);
        } catch (IOException e) {
            errorMsg = "Error reading file.";
        } finally {
            if (!errorMsg.isEmpty()) textViewError.append("\n" + errorMsg);
        }
    }


    // Handles permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

}
