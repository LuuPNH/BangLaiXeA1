package com.example.finaldoan.Models;

public class YoutubeVideo {
    String video_title;
    String video_url;

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public YoutubeVideo(String video_title, String video_url) {
        this.video_title = video_title;
        this.video_url = video_url;
    }

    public  YoutubeVideo() {}
}
