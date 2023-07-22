package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zybooks.testworldsalsa.HomePage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Workshops;

import DialogFragments.DialogFragment_Delete;
import DialogFragments.DialogFragment_Incorrect;

/** get the workshops you've bought */
public class ProfileWorkshopPage extends AppCompatActivity {

    SalsaDataBase dataBase;

    String username2 ;
    String password2 ;
    int userid;
    int workshopTally = 0;
    int workshopid;
    String name;
    String type;

    TextView  textViewincrementNumber ;
    TextView textViewincrementNumber2 ;
    Button  buttonincrementNumber;
    TextView textView3 ;

    LinearLayout LL2;

    int userID = SalsaDataBase.getloggedin().getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_workshop_page);

        dataBase = new SalsaDataBase(this);

        /** get the existing layout to be used */
         LL2 = findViewById(R.id.LL2);

        username2 = getIntent().getStringExtra("username");
        password2 = getIntent().getStringExtra("password");

        textView3 = findViewById(R.id.workshopTally);

        /** run code after gathering info */
        getWorkshops();

        textView3.setText("You have " + workshopTally + " workshops " + SalsaDataBase.getloggedin().getName());
    }

    /** get the workshops you've bought
     *
     */
    private void getWorkshops() {

        /** get assigned workshops */
        Cursor cursor2 = dataBase.readAssignedWorkshops(userID);
        while (cursor2.moveToNext()) {
            workshopid = Integer.parseInt(cursor2.getString(0));


        /** get workshop name you have */
        Cursor cursor3 = dataBase.readWorkshops(workshopid);

     //   for (int i=0; i < cursor3.getCount(); ++i ) {
            while (cursor3.moveToNext()) {
                name = cursor3.getString(0);
                type = cursor3.getString(1);


        /** create textviews and cancel button */
            textViewincrementNumber = new TextView(this);
            textViewincrementNumber2 = new TextView(this);
             buttonincrementNumber = new Button(this);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        /** set parameters */
                buttonincrementNumber.setText("Cancel Workshop");
                buttonincrementNumber.setBackgroundColor(Color.parseColor("#9C27B0"));
                buttonincrementNumber.setLayoutParams(params);
                textViewincrementNumber.setLayoutParams(params);
                textViewincrementNumber.setGravity(Gravity.CENTER);
                textViewincrementNumber.setText(name);
                textViewincrementNumber2.setText(type);
                textViewincrementNumber2.setGravity(Gravity.CENTER);
                textViewincrementNumber.setTextColor(Color.parseColor("#050505"));

        /** onclick listener
         *
         */
                buttonincrementNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteButton();
                }
            });

        /** add to layout */
        LL2.addView(textViewincrementNumber);
        LL2.addView(textViewincrementNumber2);

        LL2.addView(buttonincrementNumber);

        workshopTally = workshopTally + 1;
   
            }
            cursor3.close();
        }
        cursor2.close();
    }


    public void deleteButton() {
        int salsa =   dataBase.deleteAssignedWorkshop(userID);

        if (salsa > 0) {
            DialogFragment_Delete delete = new DialogFragment_Delete();
            delete.show(getSupportFragmentManager(), "delete");

            LL2.removeView(textViewincrementNumber);
            LL2.removeView(textViewincrementNumber2);
            LL2.removeView(buttonincrementNumber);

            workshopTally = workshopTally - 1;
            //          getWorkshops();
            textView3.setText("You have " + workshopTally + " workshops " + SalsaDataBase.getloggedin().getName());
        }

        else {
            DialogFragment_Incorrect no = new DialogFragment_Incorrect();
            no.show(getSupportFragmentManager(), "no");
        }

    }

    /** go to workshop page
     *
     * @param view workshop
     */
    public void workshopClick(View view) {
        Intent work = new Intent(this, Workshops.class);
        startActivity(work);
    }

    /**
     * go to profile page
     * @param view profile
     */
    public void profileClick(View view) {

        Intent info = new Intent(this, ProfileInformationPage.class);
        info.putExtra("username", username2);
        info.putExtra("password", password2);
        startActivity(info);
    }

    /**
     * profile tickets page
     * @param view tickets
     */
    public void profileTickets(View view) {
        Intent info = new Intent(this, ProfileTicketPage.class);
        info.putExtra("username", username2);
        info.putExtra("password", password2);
        startActivity(info);
    }

    /**
     * profile workshops
     * @param view workshops
     */
    public void profileWorkshopsClick(View view) {
        Intent info = new Intent(this, ProfileWorkshopPage.class);
        info.putExtra("username", username2);
        info.putExtra("password", password2);
        startActivity(info);
    }

    /**
     * go to home page
     * @param view home
     */
    public void HomePageClick(View view) {
        Intent go = new Intent(this, HomePage.class);
        startActivity(go);
    }

}
