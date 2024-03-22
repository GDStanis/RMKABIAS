package ru.mirea.dvorings.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String LOG = "Lifecycle";

    // String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG,"Создано Acitivity - отработал метод onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "Меняется видимость Activity - отработал метод onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "Activity в фокусе пользователя - отработал метод onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "Activity приостановлено, фокус не на нем - отработал метод onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "Activity остановлено - отработал метод onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "Activity уничтожено - отработал метод onDestroy");
    }



}
