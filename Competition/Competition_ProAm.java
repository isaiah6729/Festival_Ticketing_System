package Competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.zybooks.testworldsalsa.ConfirmationPage;
import DialogFragments.DialogFragment_Addition;
import DialogFragments.DialogFragment_MissingEmail;
import DialogFragments.DialogFragment_MissingInput;
import DialogFragments.DialogFragment_PhoneNumber;

import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import java.time.LocalDateTime;

/** this gets the adult competition information */
public class Competition_ProAm extends AppCompatActivity {

    int number;
    int number2;

    String name;
    String partnersname;
    String phoneNumber;
    String email;
    String proAm;

    EditText phonenumber2;
    EditText name2;
    EditText email2;
    EditText partnersname2;

    SalsaDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_pro_am);

        dataBase = new SalsaDataBase(this);

        name2 = (findViewById(R.id.proname));
        phonenumber2 = findViewById(R.id.pronumber);
        email2 = (findViewById(R.id.proemail));
        partnersname2 = (findViewById(R.id.partnername));

    }

    /**
     * choose a category
     *
     * @param view category
     */
    public void proClick(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.probutton) {
            if (checked) {
                number2 = 1;
            }
        }
        else if (view.getId() == R.id.ambutton) {
            if (checked) {
                number2 = 2;
            }
        }
        else if (view.getId() == R.id.proambutton) {
            if (checked) {
                number2 = 3;
            }
        }
    }

    /**
     * choose a dance
     *
     * @param view dance
     */
    public void amClick(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.salsabutton) {
            if (checked) {
                if (number2 == 1) {
                    number = 1;
                }
                else if (number2 == 2) {
                    number = 2;
                }
                else if (number2 == 3) {
                    number = 3;
                }
            }
        }

        else if (view.getId() == R.id.bachatabutton) {
            if (checked) {

                  if (number2 == 1) {
                    number = 4;
                }
                  else if (number2 == 2) {
                    number = 5;
                }
                  else if (number2 == 3) {
                    number = 6;
                }
            }
        }
        else if (view.getId() == R.id.chabutton) {
            if (checked) {
                   if (number2 == 1) {
                    number = 7;
                }
                   else if (number2 == 2) {
                    number = 8;
                }
                   else if (number2 == 3) {
                    number = 9;
                }
            }
        }
    }

    /**
     * submit your informaTION
     *
     * @param view competition
     */
    public void proSubmit(View view) {

        int userID = SalsaDataBase.getloggedin().getId();

        name = name2.getText().toString();
        partnersname = partnersname2.getText().toString();
        email = email2.getText().toString();
        phoneNumber = phonenumber2.getText().toString();

        /** date of show */
        LocalDateTime showDate = LocalDateTime.of(2023, 07, 29, 22, 00);


        /** validations */
        if (name.isEmpty() || partnersname.isEmpty() || phoneNumber.isEmpty()) {
            DialogFragment_MissingInput missing = new DialogFragment_MissingInput();
            missing.show(getSupportFragmentManager(), "missed");
        }
        else {
            if (phoneNumber.length() < 10) {
                DialogFragment_PhoneNumber missing = new DialogFragment_PhoneNumber();
                missing.show(getSupportFragmentManager(), "missing");
            }

            else {

            if (!(email.contains("@") || email.contains("."))) {
                DialogFragment_MissingEmail missing = new DialogFragment_MissingEmail();
                missing.show(getSupportFragmentManager(), "missing");
            }
            else {

                /** database */
                long salsa = dataBase.addCompetitions(number, userID, name, partnersname, phoneNumber, email, showDate, LocalDateTime.now());

                if (salsa > 0) {

                    name2.getText().clear();
                    partnersname2.getText().clear();
                    email2.getText().clear();
                    phonenumber2.getText().clear();

                    /** go to confirmation */
                    Intent confirmation = new Intent(this, ConfirmationPage.class);
                    confirmation.putExtra("proAm", number);
                    startActivity(confirmation);

                  }
                }
            }
        }
    }
}