package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

class Person implements Serializable {
    String name;
    int age;
}

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = findViewById(R.id.listview);
        ArrayList<String> strs = new ArrayList<>();
        ArrayList<HashMap<String,Object>> maps = new ArrayList<>();
        for (int i = 0;i< 300;i++) {

            strs.add("测试TT " + i);
            HashMap<String,Object> data = new HashMap<String, Object>();
            data.put("str","测试" + i);
            maps.add(data);
        }
//        查看子类和继承关系:Type Hierarchy 快捷键ctr + H
//        MyAdapter adapter = new MyAdapter(this,strs);

        //错误提示 option + enter
//        NextAdapter adapter = new NextAdapter(strs);
//        listView.setAdapter(adapter);

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                maps,
                android.R.layout.simple_list_item_1,
                new String[]{"str"},
                new int[]{android.R.id.text1}
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//                AlertDialog dialog = builder.setTitle("提示").
//                        setMessage("消息体").
//                        setNegativeButton("取消",null).
//                        setPositiveButton("确定",null).
//                        create();
//                dialog.show();

                Intent intent = new Intent();
                intent.putExtra("title","第二个控制器");

                Person person = new Person();
                person.name = "bobo";
                intent.putExtra("person",person);
//                intent.setClass(MainActivity.this,MyActivity.class);
                intent.setAction("haha");
                startActivityForResult(intent,0);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String string = data.getStringExtra("back");

        Log.v("zzz",string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
