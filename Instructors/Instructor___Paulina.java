package Instructors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.Workshops;


/** paulina's page */
public class Instructor___Paulina extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_paulina);
        tabLayout = findViewById(R.id.paultab);
        viewPager2 = findViewById(R.id.paulViewpager2);
        Instructor___ElenaAdapter adapter = new Instructor___ElenaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(paultab);
    }


    TabLayout.OnTabSelectedListener paultab = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** paulina's page
     *
     * @param view book1
     */
    public void bookpaul1(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** paulina's page
     *
     * @param view book2
     */
    public void bookpaul2(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** paulina's page
     *
     * @param view book3
     */
    public void bookpaul3(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** paulina's page
     *
     * @param view book4
     */
    public void bookpaul4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }
}