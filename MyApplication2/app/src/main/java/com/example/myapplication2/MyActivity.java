package com.example.myapplication2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    Test1Receiver receiver;
    TestReceiver receiver1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
        Person person = (Person) intent.getSerializableExtra("person");

        final TextView textView = findViewById(R.id.textView);
        textView.setText(person.name);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent();
//                intent1.putExtra("back",textView.getText());
//                setResult(0,intent1);
//                finish();

                Intent intent1 = new Intent();
                intent1.setClass(MyActivity.this,nextActivity.class);
                startActivity(intent1);
            }
        });



        receiver = new Test1Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.myapplication2.action.testReceiver");
        intentFilter.setPriority(600);
        registerReceiver(receiver,intentFilter);

        receiver1000 = new TestReceiver();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.example.myapplication2.action.testReceiver");
        intentFilter0.setPriority(1000);
        registerReceiver(receiver1000,intentFilter0);
    }

    public void clickAction(View view) {

        Intent intent = new Intent();
        intent.setAction("com.example.myapplication2.action.testReceiver");
//        intent.setComponent(new ComponentName("com.example.myapplication2","com.example.myapplication2.TestReceiver"));
        sendOrderedBroadcast(intent,null,new TestEndReceiver(),null,0,"广播消息",null);

    }

    public void serviceAction(View view) {

        Intent intent = new Intent(this,TestService.class);

        startService(intent);

//        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("zzz","页面开始");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v("zzz","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("zzz","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("zzz","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("zzz","页面停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(receiver1000);
        Log.v("zzz","页面销毁");
    }
}
