package Instructors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zybooks.testworldsalsa.CheckOutPage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Workshops;

import DialogFragments.DialogFragment_LogIn_First;

/** tito's page */
public class Instructor___Tito extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_tito);
        tabLayout = findViewById(R.id.titotab);
        viewPager2 = findViewById(R.id.titoViewpager2);
        Instructor___ElenaAdapter adapter = new Instructor___ElenaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(titotab);
    }

    /** tito's page tabs
     *
     */
    TabLayout.OnTabSelectedListener titotab = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** tito's page
     *
     * @param view book1
     */
    public void bookTito1(View view) {
        int workshopnumber = 5;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("tito", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** tito's page
     *
     * @param view book2
     */
    public void bookTito2(View view) {
        int workshopnumber = 10;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("tito", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** tito's page
     *
     * @param view book3
     */
    public void bookTito3(View view) {
        int workshopnumber = 15;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("tito", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** tito's page
     *
     * @param view book4
     */
    public void bookTito4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }
}