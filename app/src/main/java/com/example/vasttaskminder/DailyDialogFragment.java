package com.example.vasttaskminder;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DailyDialogFragment extends androidx.fragment.app.DialogFragment {
    public ReturnTask returnTask;
    private static final String TAG = "Dialog Fragment ";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View dailyView = inflater.inflate(R.layout.add_daily_task_dialog, container, false);

        EditText dailyEditText = dailyView.findViewById(R.id.editTextDailyTask);

        Button dailyClose = dailyView.findViewById(R.id.buttonCloseDaily);
        dailyClose.setOnClickListener(view -> dismiss());

        Button dailyAddTask = dailyView.findViewById(R.id.buttonAddTaskDaily);
        dailyAddTask.setOnClickListener(view -> {
            String task = dailyEditText.getText().toString();
            System.out.println(task);
            returnTask.returnDailyTask(task);
            dismiss();
        });

        return dailyView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            returnTask = (ReturnTask)getActivity();
        }
        catch (ClassCastException e) {
            Log.e(TAG, "onAttach: Failed");
        }
    }
}
