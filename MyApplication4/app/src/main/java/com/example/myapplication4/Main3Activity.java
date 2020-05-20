package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RecyclerView recyclerView = findViewById(R.id.recycle1);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new RecyclerView.Adapter() {

            class AHolder extends RecyclerView.ViewHolder {

                TextView textView;
                public AHolder(@NonNull TextView textView) {
                    super(textView);

                    this.textView = textView;
                }
            }
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                TextView textView = new TextView(parent.getContext());

                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

                return new AHolder(textView);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                AHolder aHolder = (AHolder)holder;
                aHolder.textView.setText("这是一个列表子串");
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        };

        recyclerView.setAdapter(adapter);
    }
}
