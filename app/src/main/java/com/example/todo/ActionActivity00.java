package com.example.todo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ActionActivity00 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapterRecycler myAdapterRecycler;
    ArrayList<String> ListTask = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action00);

        try {
            ListTask = Control.readNameTask(ListTask,openFileInput("List of NameTask.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ListTask);

        myAdapterRecycler = new MyAdapterRecycler(getApplicationContext(), R.layout.model_action1, ListTask);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapterRecycler);
    }
}