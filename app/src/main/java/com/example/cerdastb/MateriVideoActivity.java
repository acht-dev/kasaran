package com.example.cerdastb;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MateriVideoActivity extends AppCompatActivity {

    VideoView videoView;
    String materiID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_video);

        videoView = (VideoView)findViewById(R.id.video);

        if(getIntent() != null){
            materiID = getIntent().getStringExtra("materiID");
        }


        MediaController media = new MediaController(this);
        Uri lokasivideo = Uri.parse("andriod.resource://"+getPackageName()+"/" + R.raw.videoedukasi);
        videoView.setVideoURI(lokasivideo);
        videoView.setMediaController(media);
        media.setAnchorView(videoView);
        videoView.start();
    }
}
