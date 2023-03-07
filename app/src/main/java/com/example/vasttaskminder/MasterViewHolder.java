package com.example.vasttaskminder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MasterViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewDaily;
    private final static String TAG = "RecyclerView ViewHolder Master List";

    public MasterViewHolder(@NonNull View itemView) {
        super(itemView);
        Log.d(TAG, " view created");
        textViewDaily = itemView.findViewById(R.id.textViewDailyTask);
    }
}
