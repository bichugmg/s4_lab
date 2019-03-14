package com.example.andlabb.speed_dial;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends AppCompatActivity {
    Button send;
    EditText text, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        send = findViewById(R.id.send);
        text = findViewById(R.id.text);
        number = findViewById(R.id.number);

       ActivityCompat.requestPermissions(sms.this, new String[]{Manifest.permission.SEND_SMS}, 1);

        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                sendSMS(number.getText().toString(), text.getText().toString());
            }
        });


        Intent sms_intent=getIntent();
        Bundle b=sms_intent.getExtras();

        if(b!=null){
            Toast.makeText(getApplicationContext(),b.getString("sms_str"),Toast.LENGTH_LONG).show();
            // Display SMS in the TextView

        }
    }



    BroadcastReceiver deliveryBroadcastReciever = new DeliverReceiver();;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void sendSMS(String phoneNumber, String message) {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(
                SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        registerReceiver(deliveryBroadcastReciever, new IntentFilter(DELIVERED));


        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, deliveredPI);







        Intent notificationIntent = new Intent(getApplicationContext(), sms.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),
                1, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = getApplicationContext().getResources();
        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher_background))
                .setTicker("")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("SMS")
                .setContentText("send");
        Notification n = builder.build();

        nm.notify(1, n);










    }
    class DeliverReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent arg1) {
            switch (getResultCode()) {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "sms_delivered",
                            Toast.LENGTH_SHORT).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getBaseContext(), "sms_not_delivered",
                            Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }

}
