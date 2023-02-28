package com.example.vasttaskminder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DailyRecyclerViewAdapter extends RecyclerView.Adapter<DailyViewHolder> {
    private final ArrayList<String> dailyTask;
    private final LayoutInflater dailyInflater;
    private final static String TAG = "RecyclerView Adapter";

    public DailyRecyclerViewAdapter(Context context, ArrayList<String> dailyTasks) {
        this.dailyInflater = LayoutInflater.from(context);
        this.dailyTask = dailyTasks;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = dailyInflater.inflate(R.layout.daily_task_row, parent, false);
        Log.d(TAG, " Recyclerview created");
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        String task = dailyTask.get(position);
        holder.textViewDaily.setText(task);
    }

    @Override
    public int getItemCount() {
        if (dailyTask == null) {
            return 0 ;
        } else {
            return dailyTask.size();
        }
    }
}
