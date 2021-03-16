package com.example.todo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ActionFragment extends Fragment {



    private Button addTasks, editTasks, delete;
    public ActionFragment() {

    }

    public interface clickListener{
        void onClickListener(int position);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_action, container, false);

        addTasks = v.findViewById(R.id.addTask);
        delete = v.findViewById(R.id.deleteListAndTask);
        editTasks = v.findViewById(R.id.editTask);


        return v;
    }
}