package Competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.testworldsalsa.CheckOutPage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Tickets;

import DialogFragments.DialogFragment_LogIn_First;
import Instructors.Instructor___Tito;

/** competition page */
public class Competitions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
    }

    /**
     * go to kids page
     * @param view kids
     */
    public void kidsComp(View view) {

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent kids = new Intent(this, CompetitionKids.class);
                startActivity(kids);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /**
     * buy a ticket
     * @param view buy
     */
    public void buytixClick(View view) {
        Intent buy = new Intent(this, Tickets.class);
        startActivity(buy);
    }

    /**
     * pro competition
     * @param view pro
     */
    public void proamClick(View view) {

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {
                Intent pro = new Intent(this, Competition_ProAm.class);
                startActivity(pro);
            }
        } catch (NullPointerException e) {
            DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
            log.show(getSupportFragmentManager(), "log");
        }
    }

    /**
     * instructor panelist
     * @param view panel
     */
    public void performClick(View view) {
        Intent pro2 = new Intent(this, Instructor___Tito.class);
        startActivity(pro2);
    }
}