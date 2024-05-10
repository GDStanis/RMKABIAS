package ru.mirea.dvorings.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String time = extras.getString("time");
            String number = extras.getString("number");
            int groupNum = Integer.parseInt(number);
            TextView textView = findViewById(R.id.finalText);
            textView.setText("КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА \nПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ " +
                    Math.round(Math.pow(groupNum, 2)) + ",\n а текущее время: " + time);
        }
    }
}