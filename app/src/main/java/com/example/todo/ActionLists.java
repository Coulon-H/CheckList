package com.example.todo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActionLists extends AppCompatActivity {

    private Button addTasks, editTasks, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_lists);

        addTasks = findViewById(R.id.addTask);
        delete = findViewById(R.id.deleteListAndTask);
        editTasks = findViewById(R.id.editTask);



    }
}