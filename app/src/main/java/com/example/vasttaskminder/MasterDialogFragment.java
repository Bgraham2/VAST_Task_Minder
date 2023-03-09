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

public class MasterDialogFragment extends androidx.fragment.app.DialogFragment {
    public ReturnMasterTask returnTask;
    private static final String TAG = " Master Dialog Fragment ";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View masterView = inflater.inflate(R.layout.add_master_task_dialog, container, false);

        EditText masterEditText = masterView.findViewById(R.id.editTextMasterTask);

        Button masterClose = masterView.findViewById(R.id.buttonCloseMaster);
        masterClose.setOnClickListener(view -> dismiss());

        Button masterAddTask = masterView.findViewById(R.id.buttonAddTaskMaster);
        masterAddTask.setOnClickListener(view -> {
            String task = masterEditText.getText().toString();
            returnTask.returnMasterTask(task);
            dismiss();
        });

        return masterView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            returnTask = (ReturnMasterTask)getActivity();
        }
        catch (ClassCastException e) {
            Log.e(TAG, "onAttach: Failed");
        }
    }
}
