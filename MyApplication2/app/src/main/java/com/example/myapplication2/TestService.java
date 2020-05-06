package com.example.myapplication2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("zzz","启动服务");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
