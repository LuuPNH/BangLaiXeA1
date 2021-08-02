package com.example.finaldoan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.example.finaldoan.ListVideo.API_KEY;
import static com.example.finaldoan.ListVideo.LINK;

public class VideoYouTuBe extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    int REQUEST_VIDEO = 123;
    YouTubePlayerView myYouTobe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_you_tu_be);
        myYouTobe = (YouTubePlayerView) findViewById(R.id.myYouTube);
        myYouTobe.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(LINK);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(VideoYouTuBe.this, REQUEST_VIDEO);
        } else {
            Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_VIDEO){
            myYouTobe.initialize(API_KEY, VideoYouTuBe.this);
        }

    }
}
