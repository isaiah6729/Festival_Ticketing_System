package Vendors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import DialogFragments.DialogFragment_Contacted;
import DialogFragments.DialogFragment_MissingEmail;
import DialogFragments.DialogFragment_MissingInput;
import DialogFragments.DialogFragment_PhoneNumber;

import com.zybooks.testworldsalsa.HomePage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Tickets;
import com.zybooks.testworldsalsa.Workshops;

/** lets register yourself as a sponsor vendor */
public class VendorProcessing extends AppCompatActivity {

    EditText number2;
    EditText name2;
    EditText email2 ;
    EditText business2 ;
    RadioButton vendor_sponsor2;

    String name;
    String number;
    String email;
    String business;
    String vendor_sponsor;

    SalsaDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_processing);

        dataBase = new SalsaDataBase(this);

         name2 = (findViewById(R.id.vendorName));
         number2 = findViewById(R.id.vendorNumber);
         email2 = (findViewById(R.id.vendorEmail));
         business2 = (findViewById(R.id.vendorBusiness));

    }

    /**
     * choose vendor or sponsor
     * @param view choose
     */
    public void sponsorClick(View view) {

        boolean checked = ((RadioButton)view).isChecked();
       if (view.getId() == R.id.vendorbutton) {
            if (checked) {
                vendor_sponsor2 = findViewById(R.id.vendorbutton);
                vendor_sponsor = vendor_sponsor2.getText().toString();
            }
        }
       else if (view.getId() == R.id.sponsorbutton) {
            if (checked) {
                vendor_sponsor2 = findViewById(R.id.sponsorbutton);
                vendor_sponsor = vendor_sponsor2.getText().toString();
            }
        }
     else  if (view.getId() == R.id.bothbutton) {
            if (checked) {
                vendor_sponsor2 = findViewById(R.id.bothbutton);
                vendor_sponsor = vendor_sponsor2.getText().toString();
            }
        }
    }

    /**
     * submit information
     * @param view submit
     */
    public void vendorsubmitClick(View view) {

        number = number2.getText().toString();
        name = name2.getText().toString();
        email = email2.getText().toString();
        business = business2.getText().toString();

        /** validations */
        if (name.isEmpty() || email.isEmpty() || business.isEmpty() || number.isEmpty()) {
            DialogFragment_MissingInput missing = new DialogFragment_MissingInput();
            missing.show(getSupportFragmentManager(), "missed");
        }
        else {
            if (number.length() < 10) {
                DialogFragment_PhoneNumber missing = new DialogFragment_PhoneNumber();
                missing.show(getSupportFragmentManager(), "missing");
            } else {

                if (!(email.contains("@") || email.contains("."))) {
                    DialogFragment_MissingEmail missing = new DialogFragment_MissingEmail();
                    missing.show(getSupportFragmentManager(), "missing");
                } else {

                    /** database */
                    long db = dataBase.addVendorSponsors(name, number, email, business, vendor_sponsor);

                    name2.getText().clear();
                    number2.getText().clear();
                    email2.getText().clear();
                    business2.getText().clear();

                    if (db > 0) {
                        DialogFragment_Contacted dialogFragmentContacted = new DialogFragment_Contacted();
                        dialogFragmentContacted.show(getSupportFragmentManager(), "vendor");

                    }
                }
            }
        }
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