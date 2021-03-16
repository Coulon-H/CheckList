package com.example.todo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MainFragment extends Fragment {


    private final Context context;
    MyAdapterRecycler myAdapterRecycler;
    RecyclerView recyclerView;
    ArrayList<String> ListTask;

    public MainFragment(Context context, ArrayList<String> ListTask) {
        this.context = context;
        this.ListTask = ListTask;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        myAdapterRecycler = new MyAdapterRecycler(context, R.layout.model_action1, ListTask);
        recyclerView = v.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(myAdapterRecycler);

        return v;
    }
}