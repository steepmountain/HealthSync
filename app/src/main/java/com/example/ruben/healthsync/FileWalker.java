package com.example.ruben.healthsync;

import android.util.Log;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Finds CSV files in a given folder, returning only the newest version.
 */

public class FileWalker {

    ArrayList<File> csvArray;

    public FileWalker() {
        csvArray = new ArrayList<>();
    }


    // Finds all CSV files in a given folder and returns them in an ArrayList<File>
    public File findCSV(String path) {

        // TODO: Option to pick which folder to search in
        // TODO: Option to pick file directly
        // TODO: make async/background task/use new thread

        // gets all the files of the root dir
        File root = new File(path);
        if (!root.exists() || !root.isDirectory()) {
            return null;
        }
        File[] list = root.listFiles();
        Log.v("Root", root.getAbsolutePath());

        // For each file in the list of files
        for (File f : list) {

            String extension = f.getName().substring(f.getName().lastIndexOf(".") + 1, f.getName().length());
            if (extension.equals("csv")) {
                csvArray.add(f);
            }
        }

        // Sorts the CSVs and uses the newest one
        if (!csvArray.isEmpty()) {
            Collections.sort(csvArray);
            File latestCSV = csvArray.get(csvArray.size()-1);
            return latestCSV;
        }
        return null;


    }
}
