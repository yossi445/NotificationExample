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
        notification.setAutoCancel(true);


        btnPush = findViewById(R.id.btnPush);
        btnPush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnPush)
        {

                notification.setSmallIcon(R.drawable.ic_launcher_background);
                notification.setTicker("this is the ticker...");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Title");
                notification.setContentText("bla bla bla.....");

                Intent intent = new Intent(this,Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
                notification.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification.build());



        }

    }
}
