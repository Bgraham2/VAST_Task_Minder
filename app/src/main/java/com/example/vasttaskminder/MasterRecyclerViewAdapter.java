package com.example.vasttaskminder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MasterRecyclerViewAdapter extends RecyclerView.Adapter<MasterViewHolder> {
    private final ArrayList<String> masterTask;
    private final LayoutInflater masterInflater;
    private final static String TAG = " Master RecyclerView Adapter";

    public MasterRecyclerViewAdapter(Context context, ArrayList<String> dailyTasks) {
        this.masterInflater = LayoutInflater.from(context);
        this.masterTask = dailyTasks;
    }

    @NonNull
    @Override
    public MasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = masterInflater.inflate(R.layout.daily_task_row, parent, false);
        Log.d(TAG, " Recyclerview created");
        return new MasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasterViewHolder holder, int position) {
        String task = masterTask.get(position);
        holder.textViewDaily.setText(task);
    }

    @Override
    public int getItemCount() {
        if (masterTask == null) {
            return 0 ;
        } else {
            return masterTask.size();
        }
    }
}
