package com.example.user.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 21-11-2017.
 */

public class IncomingSms extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final SmsManager sms = SmsManager.getDefault();
        public void onReceive(Context context, Intent intent)
    final Bundle bundle = intent.getExtras();
try {

if (bundle != null) {

final Object[] pdusObj = (Object[]) bundle.get("pdus");

for (int i = 0; i < pdusObj.length; i++) {

SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
String phoneNumber = currentMessage.getDisplayOriginatingAddress();

String senderNum = phoneNumber;
String message = currentMessage.getDisplayMessageBody();

Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);

// Show Alert
int duration = Toast.LENGTH_LONG;

    Toast toast = Toast.makeText(context, "senderNum: "+ senderNum + ", message: " + message, duration)toast.show();

} // end for loop
} // bundle is null
} catch (Exception e) {
Log.e("SmsReceiver", "Exception smsReceiver" +e);


        }

}
