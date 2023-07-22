package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/** this page goes to the events workshop and performances */
public class EventPageHost extends AppCompatActivity implements View.OnClickListener {

    private ImageView allevents;
    private ImageView performance;
    private ImageView workshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page_host);

        workshop = findViewById(R.id.workshoppicture);
        workshop.setOnClickListener(this);
        performance = findViewById(R.id.performancespicture);
        performance.setOnClickListener(this);
        allevents = findViewById(R.id.alleventspicture);
        allevents.setOnClickListener(this);
    }

    /** onclick listener to go to a page
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.workshoppicture) {
            Intent workshopintent = new Intent(this, Workshops.class);
            startActivity(workshopintent);
        }
        if (v.getId() == R.id.performancespicture) {
            Intent performanceintent = new Intent(this, Performances.class);
            startActivity(performanceintent);
        }

        if (v.getId() == R.id.alleventspicture) {
            Intent allEventsIntent = new Intent(this, Allevents.class);
            startActivity(allEventsIntent);
        }
    }
}