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

/** ana's page */
public class Instructor___Ana extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_ana);

         tabLayout = findViewById(R.id.anatab);
         viewPager2 = findViewById(R.id.anaViewpager2);
        Instructor___AnaAdapter adapter = new Instructor___AnaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(anaTab);
    }

    /** ana's page tabs */
    TabLayout.OnTabSelectedListener anaTab = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    /** ana's page
     *
     * @param view book
     */
    public void bookana1(View view) {
        int workshopnumber = 2;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("ana", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** ana's page
     *
     * @param view book 2
     */
    public void bookana2(View view) {
        int workshopnumber = 7;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("ana", workshopnumber);
                startActivity(transferana);
            }
    } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** ana's page
     *
     * @param view book 3
     */
    public void bookana3(View view) {
        int workshopnumber = 12;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("ana", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** ana's page *
     *
     * @param view book 4
     */
    public void bookana4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }

}