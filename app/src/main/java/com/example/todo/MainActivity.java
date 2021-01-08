package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button T, N, M;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        M = findViewById(R.id.Modify);
        T = findViewById(R.id.tasklists);
        N = findViewById(R.id.newlists);

        // Go to the Lists already registered
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        N.setOnClickListener(this); //Lead to the CreationActivity

        //Lead to the Possibles actions who can be done on The Lists
        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActionLists.class);
                startActivity(intent);
            }
        });
    }

    //Method used by N
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CreationActivity.class);
        startActivity(intent);
    }

}