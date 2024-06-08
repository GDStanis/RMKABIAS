package ru.mirea.dvorings.Lesson4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.dvorings.Lesson4.databinding.ActivityMp3Binding;

public class MP3Activity extends AppCompatActivity {

    private ActivityMp3Binding binding;
    public boolean btnPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMp3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.playButton.setOnClickListener(view -> {
            btnPlay = !btnPlay;
            if (btnPlay) {
                ((ImageButton) binding.playButton).setImageResource(android.R.drawable.ic_media_pause);
            }
            else {
                ((ImageButton) binding.playButton).setImageResource(android.R.drawable.ic_media_play);
            }
        });
    }
}
