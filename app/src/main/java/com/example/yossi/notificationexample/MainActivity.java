package com.example.yossi.notificationexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPush;
    NotificationCompat.Builder notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true); // ההתראה תיעלם בלחיצה



        btnPush = findViewById(R.id.btnPush);
        btnPush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnPush)
        {
            notification.setSmallIcon(R.drawable.ic_launcher_background);
            notification.setTicker("ticker..."); //הטקסט שיופיע בשורה העליונה כשההתראה תיכנס
            notification.setWhen( System.currentTimeMillis());//מתי תופיע ההתראה - עכשיו, בזמן לחיצה
            notification.setContentTitle("content title");
            notification.setContentText("the body of the notification");

            Intent intent = new Intent(this,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

            notification.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(111, notification.build());



        }

    }
}
