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

/** fausto's page */
public class Instructor___Fausto extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_fausto);

        tabLayout = findViewById(R.id.faustotab);
        viewPager2 = findViewById(R.id.faustoViewpager2);
        Instructor___ElenaAdapter adapter = new Instructor___ElenaAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(faustotab);
    }

    TabLayout.OnTabSelectedListener faustotab = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** fausto's page
     *
     * @param view book1
     */
    public void bookfausto1(View view) {
        int workshopnumber = 3;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("fausto", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** fausto's page
     *
     * @param view book2
     */
    public void bookfausto2(View view) {
        int workshopnumber = 8;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("fausto", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** fausto's page
     *
     * @param view book3
     */
    public void bookfausto3(View view) {
        int workshopnumber = 13;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("fausto", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** fausto's page
     *
     * @param view book4
     */
    public void bookfausto4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }
}