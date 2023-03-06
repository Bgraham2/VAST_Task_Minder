package com.example.vasttaskminder;

import android.content.Context;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    private static final String FILENAME = "dailyTask.dat";
    private static final String FILENAME_MASTER_LIST = "masterTask.dat";
    private static final String TAG = "File Helper";

    public static void writeDailyTasks(ArrayList<String> items, Context context) {

        try {

            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
            Log.d(TAG, " Daily File updated");

        }
        catch (IOException e) {

            Log.e(TAG, e.getMessage());

        }

    }

    public static ArrayList<String> readDailyTasks(Context context) {

        ArrayList<String> itemList = new ArrayList<>();

        try {

            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //noinspection unchecked
            itemList = (ArrayList<String>) ois.readObject();
            Log.d(TAG, " Daily File read");

        }
        catch (IOException | ClassNotFoundException e) {

            Log.e(TAG, e.getMessage());

        }

        return itemList;

    }

    public static void writeMasterTasks(ArrayList<String> items, Context context) {

        try {

            FileOutputStream fos = context.openFileOutput(FILENAME_MASTER_LIST, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
            Log.d(TAG, " Master File updated");

        }
        catch (IOException e) {

            Log.e(TAG, e.getMessage());

        }

    }

    public static ArrayList<String> readMasterTasks(Context context) {

        ArrayList<String> itemList = new ArrayList<>();

        try {

            FileInputStream fis = context.openFileInput(FILENAME_MASTER_LIST);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //noinspection unchecked
            itemList = (ArrayList<String>) ois.readObject();
            Log.d(TAG, " Master File read");

        }
        catch (IOException | ClassNotFoundException e) {

            Log.e(TAG, e.getMessage());

        }

        return itemList;

    }
}
