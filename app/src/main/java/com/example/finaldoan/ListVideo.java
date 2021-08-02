package com.example.finaldoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ListVideo extends AppCompatActivity {
    LinearLayout bt_Video1,bt_Video2,bt_Video3,bt_Video4;
    public static String API_KEY = "AIzaSyBbj2x_1zLTS6TTEcSujD922FezDNKy1rA";
    public static String LINK = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);
        bt_Video1 = (LinearLayout)findViewById(R.id.bt_video1);
        bt_Video2 = (LinearLayout)findViewById(R.id.bt_video2);
        bt_Video3 = (LinearLayout)findViewById(R.id.bt_video3);
        bt_Video4 = (LinearLayout)findViewById(R.id.bt_video4);

        bt_Video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LINK = "GSBybbOUsKg";
                Intent intent = new Intent(ListVideo.this,VideoYouTuBe.class);
                startActivity(intent);
            }
        });
        bt_Video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LINK = "c_k3CZ0szZw";
                Intent intent = new Intent(ListVideo.this,VideoYouTuBe.class);
                startActivity(intent);
            }
        });
        bt_Video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LINK = "wF5Ho7T5vaE";
                Intent intent = new Intent(ListVideo.this,VideoYouTuBe.class);
                startActivity(intent);
            }
        });
        bt_Video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LINK = "3WYM2imQ-eg";
                Intent intent = new Intent(ListVideo.this,VideoYouTuBe.class);
                startActivity(intent);
            }
        });

    }
}
