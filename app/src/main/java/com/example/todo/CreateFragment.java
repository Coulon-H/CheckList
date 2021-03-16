package com.example.todo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class CreateFragment extends Fragment {

    private final Context context;
    int cpt = 1;
    Button tS, lS, dL;
    EditText task;
    TextView cT;
    ArrayList<String> TaskList;


    public CreateFragment(Context context) {
        this.context = context;
        TaskList = new ArrayList<>();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_create, container, false);

        cT = v.findViewById(R.id.cptTask);
        task = v.findViewById(R.id.task);
        tS = v.findViewById(R.id.tasksaver);
        lS = v.findViewById(R.id.listsaver);
        dL = v.findViewById(R.id.delList);


        cT.setText("Task " + cpt);

        tS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Save the task in the list
                String tasks = task.getText().toString();
                TaskList.add(tasks);
                cpt++;
                cT.setText("Task " + cpt);
                task.setText("");
            }
        });

        lS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Get the taskList and Lead to the NameActivity
                Intent i = new Intent(context, NameActivity.class);
                i.putStringArrayListExtra("List", TaskList);
                startActivity(i);
            }
        });

        // Send back to the Main Activity
        //dL.setOnClickListener(this);
        return v;
    }
}