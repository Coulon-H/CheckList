package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterRecycler extends RecyclerView.Adapter<MyAdapterRecycler.MyViewHolder> {

    Context c;
    int r;
    ArrayList<String> l;

    MyAdapterRecycler(Context context, int res, ArrayList<String> list){
        c = context;
        r = res;
        l = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(r,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameLister.setText(l.get(position));
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameLister;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameLister = itemView.findViewById(R.id.nameLister);
        }


    }
}
