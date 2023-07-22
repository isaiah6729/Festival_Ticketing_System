package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/** this class allows you to contact us */
public class ContactUs extends AppCompatActivity {

    TextView email1;
    String sendEmail1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        email1 = findViewById(R.id.email1);

    }

    /**sends email to owner
     *
     * @param view send email
     */
    public void emailClick(View view) {

        int draw = R.drawable.people;
        sendEmail1 = email1.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, sendEmail1);
        email.putExtra(Intent.EXTRA_SUBJECT, "Inquiry - LA AfroSon Festival");
//      email.putExtra(Intent.EXTRA_TEXT, "HERE WE GO");

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an email" + getDrawable(draw)));
    }
}