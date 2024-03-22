package ru.mirea.dvorings.notificationapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    String LOG = "MainLifecycle";

    private int PermissionCode = 200;

    private static final String CHANNEL_ID = "com.mirea.asd.notification.ANDROID";

    @RequiresApi (api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.
                POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.d(MainActivity.class.getSimpleName().toString(), "Разрешения получены");
        } else {
            Log.d(MainActivity.class.getSimpleName().toString(), "Нет разрешений!");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
                            POST_NOTIFICATIONS}, PermissionCode);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "Меняется видимость MainActivity - отработал метод onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "MainActivity в фокусе пользователя - отработал метод onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "MainActivity приостановлено, фокус не на нем - отработал метод onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "MainActivity остановлено - отработал метод onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "MainActivity уничтожено - отработал метод onDestroy");
    }

    public void onClickSendNot (View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentText("Hey, check this out!")
                .setSmallIcon(R.drawable.kitten)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("You won a big prize! So big that it cannot be displayed here"))
                .setContentTitle("MIREA");
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Dvorin Georgy " +
                "Stanislavovich Notification", importance);
        channel.setDescription("MIREA channel");

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, builder.build());
    }
}