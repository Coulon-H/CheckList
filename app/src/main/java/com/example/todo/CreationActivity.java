package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CreationActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> TaskList;
    int cpt = 1;
    Button tS, lS, dL;
    EditText task;
    TextView cT;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        TaskList = new ArrayList<>();

        cT = findViewById(R.id.cptTask);
        task = findViewById(R.id.task);
        tS = findViewById(R.id.tasksaver);
        lS = findViewById(R.id.listsaver);
        dL = findViewById(R.id.delList);


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
                Intent i = new Intent(CreationActivity.this, NameActivity.class);
                i.putStringArrayListExtra("List", TaskList);
                startActivity(i);
            }
        });

        // Send back to the Main Activity
        dL.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(CreationActivity.this, MainActivity.class);
        startActivity(i);
    }

}