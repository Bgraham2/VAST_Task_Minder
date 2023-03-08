package com.example.vasttaskminder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ReturnTask {
    private final static String TAG = "Main Activity";
    private ArrayList<String> dailyTasks;
    private DailyRecyclerViewAdapter dailyRecyclerViewAdapter;
    private RecyclerView dailyRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyTasks = FileHelper.readDailyTasks(this);

        initDailyRecyclerView();
        initAddDailyTaskButton();
        initMasterTaskButton();
        initItemTouchHelper();
    }

    private void initMasterTaskButton() {
        Button masterListButton = findViewById(R.id.buttonMasterList);
        masterListButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MasterListActivity.class)));
    }

    private void initItemTouchHelper() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Log.d(TAG, "Task completed");
                Toast.makeText(MainActivity.this, dailyTasks.get(viewHolder.getAdapterPosition()) + " completed", Toast.LENGTH_LONG).show();
                dailyTasks.remove(viewHolder.getAdapterPosition());
                dailyRecyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(dailyRecyclerView);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Log.d(TAG, "Task deleted");
                Toast.makeText(MainActivity.this, dailyTasks.get(viewHolder.getAdapterPosition()) + " deleted", Toast.LENGTH_LONG).show();
                dailyTasks.remove(viewHolder.getAdapterPosition());
                FileHelper.writeDailyTasks(dailyTasks, MainActivity.this);
                dailyRecyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(dailyRecyclerView);
    }

    private void initAddDailyTaskButton() {
        Button dailyAddButton = findViewById(R.id.buttonAddDailyTask);
        dailyAddButton.setOnClickListener(view -> {
            DailyDialogFragment dailyDialogFragment = new DailyDialogFragment();
            dailyDialogFragment.show(getSupportFragmentManager(), "Daily Task Fragment");
        });
    }

    private void initDailyRecyclerView() {
        Log.d(TAG, " Daily RecyclerView init");
        dailyRecyclerView = findViewById(R.id.recyclerViewDaily);
        dailyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dailyRecyclerViewAdapter = new DailyRecyclerViewAdapter(this, dailyTasks);
        dailyRecyclerView.setAdapter(dailyRecyclerViewAdapter);
    }

    @Override
    public void returnDailyTask(String newTask) {
        Log.d(TAG, newTask + " returned");
        dailyTasks.add(newTask);
        FileHelper.writeDailyTasks(dailyTasks, this);
        dailyRecyclerViewAdapter.notifyItemInserted(dailyTasks.size());
        Toast.makeText(this, newTask + " Added!", Toast.LENGTH_LONG).show();
    }
}