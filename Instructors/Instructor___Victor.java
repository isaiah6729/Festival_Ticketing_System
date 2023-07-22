package Instructors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.Workshops;


/** victor's page */
public class Instructor___Victor extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_instructor_victor);
        tabLayout = findViewById(R.id.victortab);
        viewPager2 = findViewById(R.id.victorViewpager2);
        Instructor___ElenaAdapter adapter = new Instructor___ElenaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(victortab);
    }

    TabLayout.OnTabSelectedListener victortab = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** victor's page
     *
     * @param view book1
     */
    public void bookvictor1(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** victor's page
     *
     * @param view book2
     */
    public void bookvictor2(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** victor's page
     *
     * @param view book3
     */
    public void bookvictor3(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** victor's page
     *
     * @param view book4
     */
    public void bookvictor4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }
}