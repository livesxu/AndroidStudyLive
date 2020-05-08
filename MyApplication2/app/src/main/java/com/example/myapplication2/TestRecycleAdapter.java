package com.example.myapplication2;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TestRecycleAdapter extends RecyclerView.Adapter {

    ArrayList<String> datas;

    public TestRecycleAdapter(ArrayList<String> list) {
        this.datas = list;
    }

    class TestView extends RecyclerView.ViewHolder {

//        TextView textView;
        public TestView(@NonNull TextView itemView) {
            super(itemView);
//            textView = itemView;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        TextView view = new TextView(viewGroup.getContext());
        view.setTextColor(viewGroup.getContext().getResources().getColorStateList(R.color.colorAccent));
//        view.setTextColor(Color.RED);
//        view.setTextColor(Color.parseColor("#ff00ff"));

        return new TestView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        TextView textView =  (TextView) viewHolder.itemView;
        textView.setText(datas.get(i));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
