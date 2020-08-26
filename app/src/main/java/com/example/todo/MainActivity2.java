package com.example.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity implements MyAdapter.customListener {

    TextView t;
    ListView test;
    ArrayList<String> ListTask = new ArrayList<>();
    ArrayList<ArrayList<String>> Tab = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        readListOfTask(); // Take the list of task
        readNameTask(); // and the list of the name
        checkerIntent(); // Check if come from the name activity


        t = findViewById(R.id.textView);
        test = findViewById(R.id.test);
        adapter = new MyAdapter(this, R.layout.row, ListTask);
        adapter.setCustomListener(this); // customListener because I cannot use a simple OnItemClickListener
        test.setAdapter(adapter);
    }


    private void checkerIntent(){
        if(getIntent().hasExtra("List")){
            Intent i = getIntent();
            ListTask.add(i.getStringExtra("NameTaskList"));
            Tab.add(i.getStringArrayListExtra("List"));
        }
    }

    private void readListOfTask(){
        try{
            FileInputStream fis = openFileInput("List of Task.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Tab = (ArrayList<ArrayList<String>>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void writeListOfTask(){
        try{
           FileOutputStream fos = openFileOutput("List of Task.txt", Context.MODE_PRIVATE);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(Tab);
           oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readNameTask(){
        try{
            FileInputStream fis = openFileInput("List of NameTask.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ListTask = (ArrayList<String>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void writeNameTask(){
        try{
            FileOutputStream fos = openFileOutput("List of NameTask.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListTask);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onStop() { //When the activity is onStop save the Lists
        super.onStop();
        writeListOfTask();
        writeNameTask();
    }



    @Override
    public void onButtonListener(int position) {
        Intent is = new Intent(MainActivity2.this, LastActivity.class);
        is.putExtra("NameList", ListTask.get(position));
        is.putStringArrayListExtra("TaskList", Tab.get(position));
        startActivity(is);
    }
}