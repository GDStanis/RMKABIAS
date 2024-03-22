package ru.mirea.dvorings.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    String LOG = "SecondLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView_forAct1);
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            String userData = arguments.get("userData").toString();
            textView.setText(userData);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "Меняется видимость SecondActivity - отработал метод onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "SecondActivity в фокусе пользователя - отработал метод onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "SecondActivity приостановлено, фокус не на нем - отработал метод onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "SecondActivity остановлено - отработал метод onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "SecondActivity уничтожено - отработал метод onDestroy");
    }

}