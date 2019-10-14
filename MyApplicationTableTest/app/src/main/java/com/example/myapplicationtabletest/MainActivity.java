package com.example.myapplicationtabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = {"pp","tt"};
        ListView listView = findViewById(R.id.list);

        ArrayList<String> datas = new ArrayList<>();
        for (int i =0 ;i < 300; i++){

            String t = "测试" + i;

            datas.add(t);
        }

        listView.setAdapter(new MainADapter(this,datas));
    }
}
