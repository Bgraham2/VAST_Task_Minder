package com.example.vasttaskminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MasterListActivity extends AppCompatActivity implements ReturnMasterTask {

    private final static String TAG = "Master List Activity";
    private ArrayList<String> masterList;
    private RecyclerView masterListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_list_layout);

        masterList = FileHelper.readMasterTasks(this);

        initMasterListRecyclerView();
        initMasterAddButton();
    }

    private void initMasterAddButton() {

    }

    private void initMasterListRecyclerView() {
        Log.d(TAG, " Master RecyclerView init");
    }

    @Override
    public void returnMasterTask(String task) {

    }
}