package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import Competition.Competitions;
import Instructors.Instructors;
import Vendors.Vendors;

/** the home page that goes to all the pages */
public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    /**
     *  instructors page
     * @param view instructors
     */
    public void instructorsClick(View view) {
        Intent instructorsIntent = new Intent(this, Instructors.class);
        startActivity(instructorsIntent);
    }

    /**
     *  workshops performance page
     * @param view performances
     */
    public void workshopPerformancOnClick(View view) {
        Intent workshopIntent = new Intent(this, EventPageHost.class);
        startActivity(workshopIntent);
    }

    /**
     *  competition page
     * @param view competitions
     */
    public void competitionClick(View view) {
        Intent competitionIntent = new Intent(this, Competitions.class);
        startActivity(competitionIntent);
    }

    /**
     *  schedule page
     * @param view schedule
     */
    public void scheduleClick(View view) {
        Intent eventIntent = new Intent(this, Allevents.class);
        startActivity(eventIntent);

    }

    /**
     *  vendors page
     * @param view vendors
     */
    public void vendorClick(View view) {
        Intent vendorIntent = new Intent(this, Vendors.class);
        startActivity(vendorIntent);
    }

    /**
     *  concerts page
     * @param view concerts
     */
    public void concertClick(View view) {
        Intent concertIntent = new Intent(this, ConcertsDeejays.class);
        startActivity(concertIntent);
    }

    /**
     *  news page
     * @param view news
     */
    public void newsClick(View view) {
        Intent newsIntent = new Intent(this, News.class);
        startActivity(newsIntent);
    }

    /**
     *  contact us page
     * @param view contacts
     */

    public void feedbackClick(View view) {
        Intent contactIntent = new Intent(this, ContactUs.class);
        startActivity(contactIntent);
    }

    /**
     *  photos page
     * @param view photos
     */
    public void photoGalleryClick(View view) {
        Intent photoIntent = new Intent(this, VideoGallery.class);
        startActivity(photoIntent);
    }

    /**
     *  hotels page
     * @param view hotel
     */
    public void hotelClick(View view) {
        Intent hotelIntent = new Intent(this, Hotel.class);
        startActivity(hotelIntent);
    }

    /**
     *  party events page
     * @param view parties
     */
    public void partyEventsClick(View view) {
        Intent allIntent = new Intent(this, Allevents.class);
        startActivity(allIntent);
    }
}