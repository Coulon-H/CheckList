package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NameActivity extends AppCompatActivity {

    Intent i;
    EditText sn;
    Button b;
    ArrayList<String> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        if(getIntent().hasExtra("List"))
            l = getIntent().getStringArrayListExtra("List"); // Retrieve the list

        sn = findViewById(R.id.savename);
        b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = sn.getText().toString();
                checker(s);
            }
        });

    }

    private void checker(String s){ //Take the name of the list if none give a name by default
        if(s.equals("")){
            String tlname = "Tasklist ";
            i = new Intent(NameActivity.this, MainActivity.class);
            i.putExtra("NameTaskList", tlname);
        }else{
            i = new Intent(NameActivity.this, MainActivity.class);
            i.putExtra("NameTaskList", s);
        }


        i.putStringArrayListExtra("List",l);
        startActivity(i);//Start a new Activity
    }

}