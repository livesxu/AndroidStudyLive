package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("zzz","收到通知事件1");

        String string = getResultData();

        Log.v("zzz",string);

        setResultData("一转广播消息");
    }
}
