package ru.mirea.dvorings.Lesson4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.dvorings.Lesson4.databinding.ActivityMp3Binding;

public class MP3Activity extends AppCompatActivity {

    private ActivityMp3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMp3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.playButton.setOnClickListener(view -> {
            Log.d(MP3Activity.class.getSimpleName(), "Play button clicked");
            // Add logic to play music
        });



    }
}
