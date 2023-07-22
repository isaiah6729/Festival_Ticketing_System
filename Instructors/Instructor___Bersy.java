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

/** bersy's page */
public class Instructor___Bersy extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_bersy);

        tabLayout = findViewById(R.id.bersytab);
        viewPager2 = findViewById(R.id.bersyViewpager2);
        Instructor___BersyAdapter adapter = new Instructor___BersyAdapter(this);
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(bersyTab);
    }


    /** bersy's page tabs
     *
     */
    TabLayout.OnTabSelectedListener bersyTab = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
           viewPager2.setCurrentItem(tab.getPosition());
            }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {}

        @Override
        public void onTabReselected(TabLayout.Tab tab) {}
    };

    /** bersy's page
     *
     * @param view book1
     */
    public void bookbersy1(View view) {
        int workshopnumber = 4;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("bersy", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** bersy's page
     *
     * @param view book2
     */
    public void bookbersy2(View view) {
        int workshopnumber = 9;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("bersy", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** bersy's page
     *
     * @param view book3
     */
    public void bookbersy3(View view) {
        int workshopnumber = 14;

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent transferana = new Intent(this, CheckOutPage.class);
                transferana.putExtra("bersy", workshopnumber);
                startActivity(transferana);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /** bersy's page
     *
     * @param view book4
     */
    public void bookbersy4(View view) {
        Intent send = new Intent(this, Workshops.class);
        startActivity(send);
    }


}


