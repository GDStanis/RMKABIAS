package ru.mirea.dvorings.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void onBtnClick (View view) {
        EditText userInput = findViewById(R.id.editTextText);
        Integer msgLength = userInput.getText().toString().length();
        Toast.makeText(MainActivity.this, "СТУДЕНТ №5 ГРУППА БИСО-01-19 " +
                "Количество символов - " + msgLength, Toast.LENGTH_LONG).show();
    }
}