package com.example.teaching.smsandbroadcastreceiver2017;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;

/**
 * This is our custom BroadcastReceiver class that we will declare in the manifest
 * to receive broadcast Intents.
 */

public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("DEBUG: our BroadcastReceiver recieved an intent (SMS)!");
        try{
            //getMEssagesFromIntent is a convenience method to parse SMS messages out of intents
            SmsMessage[] messages = getMessagesFromIntent(intent);
            //for each message in the messages array
            for(SmsMessage message : messages){
                System.out.println("SMS Intercepted! : " + message.toString()
                        + " " + message.getDisplayMessageBody() + " FROM: "
                        + message.getDisplayOriginatingAddress());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
