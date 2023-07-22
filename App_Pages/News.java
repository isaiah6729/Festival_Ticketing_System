package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/** get the current news */
public class News extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }

    /**
     * go to performances
     * @param view leave page
     */
    public void performClick(View view) {
    Intent intent = new Intent(this, Performances.class);
    startActivity(intent);
    }

    /**
     * go to workshops
     * @param view workshops
     */
    public void workshopClick(View view) {
        Intent intent = new Intent(this, Workshops.class);
        startActivity(intent);
    }
}