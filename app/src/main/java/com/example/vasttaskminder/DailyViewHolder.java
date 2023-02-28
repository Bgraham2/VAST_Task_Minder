package com.example.vasttaskminder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewDaily;
    private final static String TAG = "RecyclerView ViewHolder";

    public DailyViewHolder(@NonNull View itemView) {
        super(itemView);
        Log.d(TAG, " view created");
        textViewDaily = itemView.findViewById(R.id.textViewDailyTask);
    }
}
