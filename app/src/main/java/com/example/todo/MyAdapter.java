package com.example.todo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {
    private Context context;
    private int res;
    customListener listener;

    public interface customListener{
        public void onButtonListener(int position);
    }

    public void setCustomListener(customListener listener){
        this.listener = listener;
    }


    MyAdapter(Context ct, int context, ArrayList<String> list){
        super(ct, context, list);
        this.context = ct;
        this.res = context;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String s = getItem(position);
        if(s.equals("TaskList "))
            s += position;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(res, parent, false);

        final Button b = convertView.findViewById(R.id.cptList);
        b.setText(s);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onButtonListener(position);
                }
                b.setBackgroundColor(Color.WHITE);
                Toast.makeText(context, "Button position "+ (position + 1) +" clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
