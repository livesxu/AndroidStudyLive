package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        Object[] pdus = (Object[])bundle.get("pdus");

        for (Object object:pdus) {

            SmsMessage message = SmsMessage.createFromPdu((byte[]) object);

            String address = message.getOriginatingAddress();

            String smsBody = message.getDisplayMessageBody();


        }
    }
}
