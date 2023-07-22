package Competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zybooks.testworldsalsa.ConfirmationPage;
import DialogFragments.DialogFragment_Addition;
import DialogFragments.DialogFragment_MissingEmail;
import DialogFragments.DialogFragment_MissingInput;
import DialogFragments.DialogFragment_PhoneNumber;

import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import java.time.LocalDateTime;

/** this chooses the kids competition */
public class CompetitionKids extends AppCompatActivity {

    int number;

    String kidsname;
    String email;
    String parentsname;
    String ageGroup;
    String phoneNumber;

    EditText phonenumber2;
    EditText kidsname2;
    EditText email2;
    EditText parentsname2;

    SalsaDataBase dataBase;

    RadioButton button1;
    RadioButton button2;
    RadioButton button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_kids);
        dataBase = new SalsaDataBase(this);

        kidsname2 = (findViewById(R.id.kidsname));
        phonenumber2 = findViewById(R.id.parentsnumber);
        email2 = (findViewById(R.id.parentsemail));
        parentsname2 = (findViewById(R.id.parentssname));

         button1 = findViewById(R.id.kid12button);
         button2 = findViewById(R.id.kid12button);
         button3 = findViewById(R.id.kid12button);

    }

    /**
     * choose a type
     * @param view kids
     */
    public void kidClick(View view) {

        boolean checked = ((RadioButton)view).isChecked();
        if (view.getId() == R.id.kid17button) {
            if (checked) {
                number = 1;
            }
        }
        else if (view.getId() == R.id.kid12button) {
            if (checked) {
                number = 2;
            }
        }
        else  if (view.getId() == R.id.kid8button) {
            if (checked) {
                number = 3;
            }
        }

    }

    /**
     * submit information for competition
     * @param view kids
     */
    public void kidSubmit(View view) {

        /** will come back to it */
     /*    if ( !(button1.isChecked()) && !(button2.isChecked()) && !(button3.isChecked())) {
                DialogFragment_MissingInput missing = new DialogFragment_MissingInput();
                missing.show(getSupportFragmentManager(), "missed");
        } */

        /**  userID */
        int userID = SalsaDataBase.getloggedin().getId();

        kidsname = kidsname2.getText().toString();
        parentsname = parentsname2.getText().toString();
        email = email2.getText().toString();
        phoneNumber = phonenumber2.getText().toString();

        /** show date */
        LocalDateTime showDate = LocalDateTime.of(2023,07,29, 22, 00);

        /** validations */
        if (kidsname.isEmpty() || parentsname.isEmpty() || phoneNumber.isEmpty() ){
            DialogFragment_MissingInput missing = new DialogFragment_MissingInput();
            missing.show(getSupportFragmentManager(), "missed");
        }

        else {

                if (phoneNumber.length() < 10) {
                    DialogFragment_PhoneNumber missing = new DialogFragment_PhoneNumber();
                    missing.show(getSupportFragmentManager(), "missing");
                } else {

                    if (!(email.contains("@") || email.contains("."))) {
                        DialogFragment_MissingEmail missing = new DialogFragment_MissingEmail();
                        missing.show(getSupportFragmentManager(), "missing");
                    } else {
                        /** database */
                        long salsa = dataBase.addKidsCompetitions(number, userID, kidsname, parentsname, phoneNumber, email, showDate, LocalDateTime.now());

                        if (salsa > 0) {

                            kidsname2.getText().clear();
                            parentsname2.getText().clear();
                            email2.getText().clear();
                            phonenumber2.getText().clear();

                            /** go to confirmation */
                            Intent confirmation = new Intent(this, ConfirmationPage.class);
                            confirmation.putExtra("kids", number);
                            startActivity(confirmation);
                        }
                    }
                }

        }
    }
}