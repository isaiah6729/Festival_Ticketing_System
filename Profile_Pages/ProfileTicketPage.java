package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.text.style.TextAlign;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;

import Competition.Competitions;
import Instructors.Instructors;
import Vendors.Vendors;

/** tickets that you've bought on your profile */
public class ProfileTicketPage extends AppCompatActivity {

    SalsaDataBase dataBase;

    int ticketid;
    int ticketTally = 0;
    String type;

    TextView textView ;

    LinearLayout LL;

    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ticket_page);

        dataBase = new SalsaDataBase(this);

        LL = findViewById(R.id.LL2);

        userID = SalsaDataBase.getloggedin().getId();

        getTickets();

        textView = findViewById(R.id.ticketTally);
        textView.setText("You have " + ticketTally + " tickets " + SalsaDataBase.getloggedin().getName());

    }

    /** get your tickets from database */
    private void getTickets() {

        /** get your assigned ticket number */
        Cursor cursor2 = dataBase.readAssignedTickets(userID);
        while (cursor2.moveToNext()) {
            ticketid = Integer.parseInt(cursor2.getString(0));
            LocalDateTime purchaseDate = LocalDateTime.parse(cursor2.getString(1));

            DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
           String PD = purchaseDate.format(dateTimeFormatter);

            TextView textView2 = new TextView(this);
            TextView textView3 = new TextView(this);
            textView2.setText(PD);
            textView3.setText("Purchase Type and Day");

        /** get the type of ticket you have */
        Cursor cursor3 = dataBase.readTicketType(ticketid);

        /** create new textviews */
        while (cursor3.moveToNext()) {
            type = cursor3.getString(0);


        textView = new TextView(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        LinearLayout linearLayout =  new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(params);
   //     linearLayout.setLayoutParams(Gravity.CENTER);
        textView.setLayoutParams(params);
        textView2.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView2.setGravity(LinearLayout.TEXT_ALIGNMENT_GRAVITY);
            textView3.setGravity(Gravity.CENTER);
        textView.setText(type);
        textView.setText("You purchased a " + type + " pass on  " );
        textView.setTextColor(Color.parseColor("#050505"));
            textView2.setTextColor(Color.parseColor("#050505"));
            textView3.setTextColor(Color.parseColor("#050505"));
            linearLayout.addView(textView);
            linearLayout.addView(textView2);

            LL.addView(textView3);
        LL.addView(linearLayout);

            ticketTally = ticketTally + 1;
        }
            cursor3.close();
        }
        cursor2.close();

        }


    /**
     * go to tickets
     * @param view tickets
     */

    public void tickets2Click(View view) {
        Intent tix =  new Intent(this, Tickets.class);
        startActivity(tix);
    }
}
