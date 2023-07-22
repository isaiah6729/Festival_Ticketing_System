package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

/** get the performance schedule */
public class Performances extends AppCompatActivity {

    /** set up the adapter */
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performances);

        tabLayout = findViewById(R.id.performtab);
        viewPager2 = findViewById(R.id.performviewpager2);
        PerformancesAdapter adapter = new PerformancesAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(tab);
    }

    /**
     * tab listener for fragments
     */
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