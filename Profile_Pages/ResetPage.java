package ProfilePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import java.time.LocalDateTime;

import DialogFragments.DialogFragment_Addition;

/** reset username and password */
public class ResetPage extends AppCompatActivity {

        EditText username;
        EditText password;

        String username2;
        String password2;

        SalsaDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_page);

        dataBase = new SalsaDataBase(this);

        username = findViewById(R.id.resetusername);
        password = findViewById(R.id.resetpassword);

        username.getText().clear();
        password.getText().clear();

    }

    /**
     * change username password
     * @param view change
     */
    public void restSubmitClick(View view) {

        username2 = username.getText().toString();
        password2 = password.getText().toString();

        long salsa = 0;

        /** database */
            salsa = dataBase.updateLogIn(LocalDateTime.now(), username2, password2);


        /** go to new page */
        if (salsa > 0) {

            DialogFragment_Addition add = new DialogFragment_Addition();
            add.show(getSupportFragmentManager(), "add");

            Intent login = new Intent(this, LogIn.class);
            startActivity(login);

        }
    }
}