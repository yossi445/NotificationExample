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

    Button btnPush,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPush = findViewById(R.id.btnPush);
        btnPush.setOnClickListener(this);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnPush)
        {

            //phase 1 - create intent & pendindIntent
            Intent intent = new Intent(this,Main2Activity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);


            //phase 2 - builder
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setAutoCancel(true);


            //phase 3 - Notification
            Notification notification = builder.setContentIntent(pendingIntent).
                    setSmallIcon(R.drawable.ic_launcher_background). // must
                    setTicker("this is the ticker...").
                    setContentTitle("title"). //must
                    setContentText("bla bla...").
                    setWhen(System.currentTimeMillis()).
                    build();


                //phase 4  - NotificationManager
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);

        }
        else if(v==btnCancel)
        {
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(1);

        }

    }
}
