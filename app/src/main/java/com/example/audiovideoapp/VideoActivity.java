package com.example.audiovideoapp;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    String VIDEO_LINK = "https://file-examples.com/storage/fef8fbdce362705a7927afd/2017/04/file_example_MP4_480_1_5MG.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (URLUtil.isValidUrl(VIDEO_LINK)) {
            Uri uri = Uri.parse(VIDEO_LINK);
            videoView.setVideoURI(uri);
        }

        videoView.setOnPreparedListener(mediaPlayer -> {
            videoView.start();
            //videoView.getCurrentPosition();
        });

        videoView.setOnCompletionListener(mediaPlayer -> {
            Toast.makeText(VideoActivity.this, "Video finished", Toast.LENGTH_SHORT).show();
            videoView.seekTo(0);
        });
    }
}