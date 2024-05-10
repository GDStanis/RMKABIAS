package ru.mirea.dvorings.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView devBook = findViewById(R.id.txtDev);
            String devText = extras.getString(MainActivity.KEY);
            devBook.setText(String.format("Любимая книга разработчика: \n%s", devText));
        }
    }

    public void onBtnClick(View view) {
        EditText usrTxt = findViewById(R.id.txtUsr);
        String userText = usrTxt.getText().toString();
        if (!userText.isEmpty()) {
            Intent data = new Intent();
            data.putExtra(MainActivity.USER_MESSAGE, userText);
            setResult(Activity.RESULT_OK, data);
            finish();
        } else {
            Toast.makeText(this, "Введите название вашей любимой книги", Toast.LENGTH_SHORT).show();
        }
    }
}