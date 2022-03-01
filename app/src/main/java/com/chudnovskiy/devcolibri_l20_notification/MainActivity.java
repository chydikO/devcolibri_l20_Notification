package com.chudnovskiy.devcolibri_l20_notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 127;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Objects.requireNonNull(getSupportActionBar()).hide();

        Button button = (Button) findViewById(R.id.button);

        notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent
                    .getActivity(getApplicationContext(),
                            0,
                            intent,
                            PendingIntent.FLAG_CANCEL_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), String.valueOf(NOTIFICATION_ID))
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_launcher_background))
                    .setTicker("New Notification")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .setContentTitle("Notification")
                    .setContentText("Press here");

            Notification notification = builder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
            Toast.makeText(getApplicationContext(), "setOnClickListener", Toast.LENGTH_LONG).show();
        });
    }
}