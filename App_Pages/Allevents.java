package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.NavigableMap;

/** this class implements the all events page */
public class Allevents extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    /** This create brings up the tabs to be used to show all the events
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allevents);

        tabLayout = findViewById(R.id.eventstab);
        viewPager2 = findViewById(R.id.eventsviewpager2);
        AllEventsAdapter adapter = new AllEventsAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(tab);
    }

    /** tabs for selections */
    TabLayout.OnTabSelectedListener tab = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}
        @Override
        public void onTabReselected(TabLayout.Tab tab) {}

    };


}