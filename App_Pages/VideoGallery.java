package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.text.UrlAnnotation;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/** this page shows the photos */
public class VideoGallery extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_gallery);

    }
}