package Instructors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.Workshops;

/** maritza's page */
public class Instructor___Maritza extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_maritza);
        tabLayout = findViewById(R.id.martab);
        viewPager2 = findViewById(R.id.marViewpager2);
        Instructor___ElenaAdapter adapter = new Instructor___ElenaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(martab);
    }

    TabLayout.OnTabSelectedListener martab = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** maritza's page
     *
     * @param view book1
     */
    public void bookmar1(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** maritza's page
     *
     * @param view book2
     */
    public void bookmar2(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** maritza's page
     *
     * @param view book3
     */
    public void bookmar3(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

    /** maritza's page
     *
     * @param view book4
     */
    public void bookmar4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }
}