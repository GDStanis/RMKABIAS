package ru.mirea.dvorings.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String LOG = "MainLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onClickCheck (View view) {
        Uri address = Uri.parse("https://mirea.ru/");
        Intent openLinkInternet = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openLinkInternet);
    }

    public void onClickStudent (View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "ВУЗ: РТУ МИРЭА");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "ФИО: Дворин Георгий Станиславович");
        startActivity(Intent.createChooser(shareIntent, "ФИО и ВУЗ"));
    }
}