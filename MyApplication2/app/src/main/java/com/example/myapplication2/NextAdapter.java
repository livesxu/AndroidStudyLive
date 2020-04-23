package com.example.myapplication2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NextAdapter extends BaseAdapter {

    ArrayList<String> datas;

    public NextAdapter(ArrayList<String> strs) {
        datas = strs;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        TextView textView = new TextView(parent.getContext());
//        textView.setTextSize(20);
//        textView.setText(datas.get(position));

        if (convertView == null) {

            LayoutInflater from = LayoutInflater.from(parent.getContext());
            View inflate = from.inflate(R.layout.next_item, null);
            convertView = inflate;
        }
        TextView textView = (TextView)convertView.findViewById(R.id.text1);
        textView.setText(datas.get(position));

        return textView;
    }
}
