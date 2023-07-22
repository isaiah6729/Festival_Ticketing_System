package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zybooks.testworldsalsa.Allevents;
import com.zybooks.testworldsalsa.HomePage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Tickets;
import com.zybooks.testworldsalsa.Workshops;

import java.security.SecureRandom;

/** all the information of your profile */
public class ProfileInformationPage extends AppCompatActivity {

    TextView name;
    TextView email;
    TextView city;
    TextView state;
    TextView continent;

    String name2;
    String email2;
    String city2;
    String state2;
    String continent2;

    SalsaDataBase dataBase;

    /** get the username and password to bring up your account
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_information_page);

        dataBase = new SalsaDataBase(this);

        name = findViewById(R.id.profileName);
        email = findViewById(R.id.profileemail);
        state = findViewById(R.id.profilestate);
        city = findViewById(R.id.profileCity);
        continent = findViewById(R.id.profileContinent);

//        username = getIntent().getStringExtra("username");
  //      password = getIntent().getStringExtra("password");

        profilePage();

    }

    /**
     * get all your information including email and city state continent
     */
    public void profilePage() {

        Cursor cursor = dataBase.readProfile(SalsaDataBase.getloggedin().getUsername(), SalsaDataBase.getloggedin().getPassword());
        while (cursor.moveToNext()) {
             name2 = cursor.getString(0);
             email2 = cursor.getString(1);
             city2 = cursor.getString(2);
             state2 = cursor.getString(3);
             continent2 = cursor.getString(4);
        }

            cursor.close();

         name.setText(name2);
         email.setText(email2);
         city.setText(city2);
         state.setText(state2);
         continent.setText(continent2);
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