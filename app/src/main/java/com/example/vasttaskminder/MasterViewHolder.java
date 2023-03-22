package com.example.vasttaskminder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MasterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textViewDaily;
    public ReturnSelectedMasterTask returnSelectedMasterTask;
    private final static String TAG = "RecyclerView ViewHolder Master List";

    public MasterViewHolder(@NonNull View itemView) {
        super(itemView);
        Log.d(TAG, " view created");
        textViewDaily = itemView.findViewById(R.id.textViewDailyTask);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, " view created");
        String task = textViewDaily.getText().toString();
        returnSelectedMasterTask.returnSelectedTask(task);
    }
}
