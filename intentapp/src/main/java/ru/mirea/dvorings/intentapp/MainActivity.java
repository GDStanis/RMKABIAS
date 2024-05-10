package ru.mirea.dvorings.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String dateString;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);

        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        dateString = sdf.format(new Date(dateInMillis));
    }

    public void onBtnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("time", dateString);
        intent.putExtra("number", editText.getText().toString());
        startActivity(intent);
    }
}