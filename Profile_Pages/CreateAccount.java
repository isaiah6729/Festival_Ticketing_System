package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import java.time.LocalDateTime;

import DialogFragments.DialogFragment_Addition;
import DialogFragments.DialogFragment_MissingEmail;
import DialogFragments.DialogFragment_MissingInput;
import DialogFragments.DialogFragment_PhoneNumber;
import DialogFragments.DialogFragment_username_password;

public class CreateAccount extends AppCompatActivity {

    SalsaDataBase dataBase;

    EditText createname;
    EditText createemail;
    EditText createusername;
    EditText createpassword;
    String createstate;
    String createcontinent;
    String createinform;
    EditText createcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        dataBase = new SalsaDataBase(this);
        Button button = findViewById(R.id.createbutton);
        button.setOnClickListener(new View.OnClickListener() {

            /** make one ultimate listener */
            @Override
            public void onClick(View v) {
                createSubmitClick();
            }
        });

        createname = findViewById(R.id.createName);
        createemail = findViewById(R.id.createEmail);
        createpassword = findViewById(R.id.createpassword);
        createusername = findViewById(R.id.createusername);
        createcity = findViewById(R.id.createcity);

        /** now create the spinners */

        Spinner state = findViewById(R.id.statespinner2);
        Spinner continent = findViewById(R.id.continentspinner);
        Spinner inform = findViewById(R.id.informedspinner);

        ArrayAdapter<CharSequence> stateadapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> contadapter = ArrayAdapter.createFromResource(this, R.array.continents, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> informadapter = ArrayAdapter.createFromResource(this, R.array.informed, android.R.layout.simple_spinner_item);

        stateadapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        contadapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        informadapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        state.setAdapter(stateadapter);
        continent.setAdapter(contadapter);
        inform.setAdapter(informadapter);

        state.setOnItemSelectedListener(states);
        continent.setOnItemSelectedListener(continents);
        inform.setOnItemSelectedListener(informs);

    }

    AdapterView.OnItemSelectedListener states = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {}
                    else {
               createstate =  parent.getItemAtPosition(position).toString();
                    }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    AdapterView.OnItemSelectedListener continents = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {}
            else {
                createcontinent = parent.getItemAtPosition(position).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    AdapterView.OnItemSelectedListener informs = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {}
            else {
                createinform =  parent.getItemAtPosition(position).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    /** create your account
     *
     */
    public void createSubmitClick() {

        String createnameT = createname.getText().toString();
        String createemailT = createemail.getText().toString();
        String createusernameT = createusername.getText().toString();
        String createpasswordT = createpassword.getText().toString();
        String createcityT = createcity.getText().toString();


        /** validations */
        if (createnameT.isEmpty() || createemailT.isEmpty() || createusernameT.isEmpty()
                || createpasswordT.isEmpty() || createcityT.isEmpty()
                || createstate == null || createcontinent == null || createinform == null) {
            DialogFragment_MissingInput missing = new DialogFragment_MissingInput();
            missing.show(getSupportFragmentManager(), "missed");
        }
        else {
                if (!(createemailT.contains("@") || createemailT.contains("."))) {
                    DialogFragment_MissingEmail missing = new DialogFragment_MissingEmail();
                    missing.show(getSupportFragmentManager(), "missing");
                }
                else {

                    if (createusernameT.length() < 8 || createpasswordT.length() < 8 ||
                            createusernameT.length() > 15 || createpasswordT.length() > 15) {
                        DialogFragment_username_password up = new DialogFragment_username_password();
                        up.show(getSupportFragmentManager(), "up");
                    }
                    else {

                        /** database */
                        long rows = dataBase.addUser(createnameT, createemailT, createstate, createcontinent, createcityT,
                                LocalDateTime.now(), LocalDateTime.now(), createusernameT, createpasswordT, createinform);

                        if (rows > 0) {
                            createname.getText().clear();
                            createemail.getText().clear();
                            createusername.getText().clear();
                            createpassword.getText().clear();
                            createcity.getText().clear();

                            DialogFragment_Addition add = new DialogFragment_Addition();
                            add.show(getSupportFragmentManager(), "add");
                            Intent open = new Intent(this, ProfilePage.class);
                            startActivity(open);
                        }
                    }
                }
        }
    }
}