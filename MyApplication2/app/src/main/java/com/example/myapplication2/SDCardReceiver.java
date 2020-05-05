package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SDCardReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {

            Log.v("zzz","sd卡被安装");
        } else {
            Log.v("zzz","sd卡被卸载");
        }
    }
}
