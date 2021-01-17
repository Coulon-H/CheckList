package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        addTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActionLists.this, ActionActivity00.class);
                startActivity(i);
            }
        });


    }
}