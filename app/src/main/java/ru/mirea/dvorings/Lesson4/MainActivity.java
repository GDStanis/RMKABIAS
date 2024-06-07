package ru.mirea.dvorings.Lesson4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import ru.mirea.dvorings.Lesson4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_layout, new GalleryFragment());
            transaction.commit();
        }

        binding.editTextMirea.setText("Мой номер по списку №5");
        binding.buttonMirea.setOnClickListener(view -> {
            Log.d(MainActivity.class.getSimpleName(), "onClickListener");
        });

        binding.btnMp3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MP3Activity.class);
            startActivity(intent);
        });
    }
}
