package com.example.audiovideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button playMusicButton, stopMusicButton, videoButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playMusicButton = findViewById(R.id.playMusicButton);
        stopMusicButton = findViewById(R.id.stopMusicButton);
        videoButton = findViewById(R.id.videoButton);

        playMusicButton.setOnClickListener(view -> {
            String url = "https://file-examples.com/storage/fef8fbdce362705a7927afd/2017/11/file_example_MP3_700KB.mp3";
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                //e.printStackTrace();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        stopMusicButton.setOnClickListener(view -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
            } else {
                Toast.makeText(MainActivity.this, "Audio player not started", Toast.LENGTH_SHORT).show();
            }
        });

        videoButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, VideoActivity.class)));
    }
}