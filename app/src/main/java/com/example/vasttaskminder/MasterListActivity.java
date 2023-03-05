package com.example.vasttaskminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MasterListActivity extends AppCompatActivity {

    private final static String TAG = "Master List Activity";
    private ArrayList<String> masterList;
    private RecyclerView masterListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_list_layout);
    }
}