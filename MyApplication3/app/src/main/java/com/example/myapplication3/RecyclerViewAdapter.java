package com.example.myapplication3;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<String> datas;
    public RecyclerViewAdapter(ArrayList<String> list) {
        datas = list;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView view = new TextView(parent.getContext());
        view.setHeight(100);
        view.setTextColor(parent.getContext().getResources().getColorStateList(R.color.colorAccent));

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder)holder;
        myHolder.textView.setText(datas.get(position));
        myHolder.textView.setBackgroundColor(Color.parseColor("#ff00ff"));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
