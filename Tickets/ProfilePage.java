package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.zybooks.testworldsalsa.Allevents;
import com.zybooks.testworldsalsa.ConcertsDeejays;
import com.zybooks.testworldsalsa.ContactUs;
import com.zybooks.testworldsalsa.HomePage;
import com.zybooks.testworldsalsa.HomePageSpinner;
import com.zybooks.testworldsalsa.HomePageSpinnerAdapter;
import com.zybooks.testworldsalsa.Hotel;
import com.zybooks.testworldsalsa.News;
import com.zybooks.testworldsalsa.Performances;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Tickets;
import com.zybooks.testworldsalsa.VideoGallery;
import com.zybooks.testworldsalsa.Workshops;

import java.util.ArrayList;

import Competition.Competitions;
import Instructors.Instructors;
import Vendors.Vendors;

/** this is the main page of your profile */
public class ProfilePage extends AppCompatActivity {

    TextView textView;

    /** oncreate
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        textView = findViewById(R.id.profileName);
        textView.setText(SalsaDataBase.getloggedin().getName());
    }

    /**
     * profile all events
     * @param view events
     */
    public void partyEventsClick(View view) {
        Intent go = new Intent(this, Allevents.class);
        startActivity(go);
    }

    /**
     * go to home page
     * @param view homepage
     */
    public void homeClick(View view) {
        Intent leave = new Intent(this, HomePage.class);
        startActivity(leave);
    }

    /**go to workshop
     *
     * @param view workshop
     */
    public void WorkshopClick(View view) {
        Intent leave = new Intent(this, Workshops.class);
        startActivity(leave);
    }

    /**
     * go to tickets
     * @param view tickets
     */
    public void ticketsClick(View view) {
        Intent leave = new Intent(this, Tickets.class);
        startActivity(leave);
    }

}