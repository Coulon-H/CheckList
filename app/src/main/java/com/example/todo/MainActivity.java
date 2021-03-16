package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ActionFragment.clickListener{

    Button T, N, M;
    BottomNavigationView bottom;
    private static ArrayList<ArrayList<String>> Tab;
    private static ArrayList<String> ListTask;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tab = new ArrayList<>();
        ListTask = new ArrayList<>();
        bottom = findViewById(R.id.bottom);
        bottom.setOnNavigationItemSelectedListener(navListener);
        checkerIntent();


        try {
            Tab = Control.readListOfTask(Tab, openFileInput("List of Task.txt"));
            ListTask = Control.readNameTask(ListTask,openFileInput("List of NameTask.txt"));
            System.out.println(ListTask + " "+ Tab);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,
                        new MainFragment(getApplicationContext(), ListTask)).commit();

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected = null;

            switch (item.getItemId()){
                case R.id.list:
                    selected = new MainFragment(getApplicationContext(), ListTask);
                    break;
                case R.id.create:
                    selected = new CreateFragment(getApplicationContext());
                    break;
                case R.id.action:
                    selected = new ActionFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame,
                            selected).commit();

            return true;
        }
    };


    //Method used by N
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CreationActivity.class);
        startActivity(intent);
    }


    private void checkerIntent(){
        if(getIntent().hasExtra("List")){
            Intent i = getIntent();
            ListTask.add(i.getStringExtra("NameTaskList"));
            Tab.add(i.getStringArrayListExtra("List"));
            System.out.println(ListTask + "  " + Tab);
            try {
                Control.writeListOfTask(Tab ,openFileOutput("List of Task.txt", Context.MODE_PRIVATE));
                Control.writeNameTask(ListTask, openFileOutput("List of NameTask.txt", Context.MODE_PRIVATE));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


   /* @Override
    public void onButtonListener(int position) {
        /*Intent is = new Intent(MainActivity.this, LastActivity.class);
        is.putExtra("NameList", ListTask.get(position));
        is.putStringArrayListExtra("TaskList", Tab.get(position));
        startActivity(is);
    }*/

    @Override
    public void onClickListener(int position) {

    }
}