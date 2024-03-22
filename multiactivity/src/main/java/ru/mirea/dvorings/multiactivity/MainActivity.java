package ru.mirea.dvorings.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String LOG = "MainLifecycle";
    EditText userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = findViewById(R.id.userInput);
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

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String userData = userText.getText().toString();
        intent.putExtra("userData", userData);
        startActivity(intent);
    }

    public void onClickSend (View view) {
        userText = findViewById(R.id.userInput);
        String userData = userText.getText().toString();
        Toast.makeText(MainActivity.this, "Message Sent: " + userData, Toast.LENGTH_LONG).show();
    }
}
