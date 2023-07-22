package ProfilePages;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zybooks.testworldsalsa.Allevents;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import DialogFragments.DialogFragment_Incorrect;

/** logs in to your profile */
public class LogIn extends AppCompatActivity {

    /** tally up bad attempts */
    int log_attempts = 0;

    TextView textView;
    EditText username;
    EditText password;

    String username2;
    String password2;

    SalsaDataBase dataBase;


    public LogIn() throws IOException {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        dataBase = new SalsaDataBase(this);

         username = findViewById(R.id.logusername);
         password = findViewById(R.id.logpassword);

         textView = findViewById(R.id.restart);

        username.getText().clear();
        password.getText().clear();

   }

    @Override
    protected void onPause() {
        super.onPause();
        username.getText().clear();
        password.getText().clear();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SalsaDataBase.loggedOut();
        textView.setText("You have been logged out.\n Please log back in.");

    }

    /**
     * goes to events page
     * @param view events
     */
    public void partyEventsClick(View view) {
        Intent party = new Intent(this, Allevents.class);
        startActivity(party);
    }

    /**
     * change your information
     * @param view change info
     */
    public void forgotClick(View view) {
        Intent forgot = new Intent(this, ResetPage.class);
        startActivity(forgot);
    }

    /**log in to your account
     *
     * @param view log in
     * @throws IOException log in
     */
    public void loginClick(View view) throws IOException {

        username2 = username.getText().toString();
        password2 = password.getText().toString();

        /** checks database */
        Boolean salsa = dataBase.readLogIn(username2, password2);

        /** bad attempt */
        if (salsa == false) {
            log_attempts = log_attempts + 1;

            /** get a report of bad attempts */
            String message = "wrong " + log_attempts + " " + LocalDateTime.now() + "\n";
            File file = getApplicationContext().getFilesDir();
            FileOutputStream write = new FileOutputStream( new File(file, "file.txt"), true);

                try {
                    write.write(message.getBytes());
                    write.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            /** alert box */
            DialogFragment_Incorrect wrong = new DialogFragment_Incorrect();
            wrong.show(getSupportFragmentManager(), "wrong");
        }

        else {

            username.getText().clear();
            password.getText().clear();

            /** go to next page take information with you */
            Intent log = new Intent(this, ProfilePage.class);
            log.putExtra("username", username2);
            log.putExtra("password", password2);
            startActivity(log);

        }
    }

    /** create new account */
    public void createClick(View view) {
        Intent log = new Intent(this, CreateAccount.class);
        startActivity(log);
    }

}