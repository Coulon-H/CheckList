package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LastActivity extends AppCompatActivity {

    TextView nL;
    ListView lot;
    MyAdapter adapter;
    ArrayList<String> tasklist;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        checkerIntent(); // Take the name and the data of the tasklist

        nL = findViewById(R.id.namelist);
        lot = findViewById(R.id.listoftask);
        adapter = new MyAdapter(this, R.layout.row, tasklist);
        nL.setText(s);
        lot.setAdapter(adapter);

    }

    private void checkerIntent(){
        if(getIntent().hasExtra("NameList")){
            Intent i = getIntent();
            tasklist = i.getStringArrayListExtra("TaskList");
            s = i.getStringExtra("NameList");
        }
    }
}