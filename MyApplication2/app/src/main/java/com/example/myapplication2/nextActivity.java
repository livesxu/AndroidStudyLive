package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.Format;
import java.util.ArrayList;

public class nextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        RecyclerView recyclerView = findViewById(R.id.recycle);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 50;i++) {

            list.add(String.format("第%d个元素",i));
        }

        recyclerView.setAdapter(new TestRecycleAdapter(list));
    }
}
