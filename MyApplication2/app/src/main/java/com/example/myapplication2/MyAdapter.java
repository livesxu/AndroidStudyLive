package com.example.myapplication2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<String> _datas;
    Context context;

    public MyAdapter (Context c, ArrayList<String> datas) {
        _datas = datas;
        context = c;
    }

    //1.告诉系统展示几项
    @Override
    public int getCount() {
        return _datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String text = _datas.get(position);
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
