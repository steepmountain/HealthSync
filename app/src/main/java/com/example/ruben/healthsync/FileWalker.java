package com.example.ruben.healthsync;

import android.util.Log;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ruben on 25.02.2017.
 */

public class FileWalker {

    ArrayList<File> csvArray;

    public FileWalker() {
        csvArray = new ArrayList<>();
    }


    // Finds all CSV files in a given folder and returns them in an ArrayList<File>
    public ArrayList<File> findCSV(String path) {

        // TODO: Only look in SHealth folder/ downloads folder
        // TODO: make async/background task/use new thread
        // TODO: find newest file here?

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
        Collections.sort(csvArray);
        return csvArray;
    }
}
