package com.example.vasttaskminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MasterListActivity extends AppCompatActivity implements ReturnMasterTask {

    private final static String TAG = "Master List Activity";
    private ArrayList<String> masterList;
    private RecyclerView masterListRecyclerView;
    private MasterRecyclerViewAdapter masterRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_list_layout);

        masterList = FileHelper.readMasterTasks(this);

        initMasterListRecyclerView();
        initMasterAddButton();
        initReturnButton();
    }

    private void initReturnButton() {
        Button returnButton = findViewById(R.id.buttonReturn);
        returnButton.setOnClickListener(view -> finish());
    }

    private void initMasterAddButton() {
        Button masterAddButton = findViewById(R.id.buttonAddMasterTask);
        masterAddButton.setOnClickListener(view -> {
            MasterDialogFragment masterDialogFragment = new MasterDialogFragment();
            masterDialogFragment.show(getSupportFragmentManager(), "Master List Fragment");
        });
    }

    private void initMasterListRecyclerView() {
        Log.d(TAG, " Master RecyclerView init");
        masterListRecyclerView = findViewById(R.id.recyclerViewMasterList);
        masterListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        masterRecyclerViewAdapter = new MasterRecyclerViewAdapter(this, masterList);
        masterListRecyclerView.setAdapter(masterRecyclerViewAdapter);
    }

    @Override
    public void returnMasterTask(String task) {
        Log.d(TAG, task + " returned");
        masterList.add(task);
        FileHelper.writeMasterTasks(masterList, this);
        masterRecyclerViewAdapter.notifyItemInserted(masterList.size());
        Toast.makeText(this, task + " Added!", Toast.LENGTH_LONG).show();
    }
}