package com.example.myapplication3;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecyclerActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = new RecyclerView(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        list = new ArrayList<>();
        for (int i = 0; i < 50 ; i++){
            list.add(String.format("第%d个元素",i));
        }

        adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

        ConstraintLayout layout = findViewById(R.id.cLayout);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topToTop = R.id.cLayout;
        layoutParams.leftToLeft = R.id.cLayout;
        layoutParams.bottomToBottom = R.id.cLayout;
        recyclerView.setLayoutParams(layoutParams);
//        动画 https://github.com/wasabeef/recyclerview-animators
        recyclerView.setItemAnimator(new SlideInDownAnimator());

        layout.addView(recyclerView);

        TextView textView = findViewById(R.id.text11);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                list.add(2,"插入一条");
                adapter.notifyItemInserted(2);
                break;
            case R.id.action_reduce:
                list.remove(2);
                adapter.notifyItemRemoved(2);
                break;
        }

        getRequest();

        return true;
    }

    public void getRequest(){

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://192.168.200.103:8080/info").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.v("zzz","请求失败：" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()){

                    String string = response.body().string();

                    Log.v("zzz",string);
                }
            }
        });
    }
}
