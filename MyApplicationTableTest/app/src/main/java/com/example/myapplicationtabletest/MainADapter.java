package com.example.myapplicationtabletest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainADapter extends BaseAdapter {

    private ArrayList<String> datas;
    private Context context;

    public MainADapter(Context context,ArrayList<String> datas){

        this.context = context;
        this.datas = datas;
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
    public int getCount() {
        return this.datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String textSting = this.datas.get(position);

        TextView view = new TextView(this.context);

        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        view.setText(textSting);

        view.setTextSize(16);

        return view;
    }
}
