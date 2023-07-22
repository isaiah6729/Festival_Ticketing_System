package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import ProfilePages.LogIn;

/** initial page */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** enter app
     *
     * @param view enter
     */
    public void enterclick(View view) {
        Intent mainpageintent = new Intent(this, HomePage.class);
        startActivity(mainpageintent);
    }

    /**
     * buy tickets
     * @param view buy tix
     */
    public void buyticketsonclick(View view) {
        Intent buyticketsintent = new Intent(this, Tickets.class);
        startActivity(buyticketsintent);
    }

    /**
     * book hotel
     * @param view hotel
     */
    public void hotelClick(View view) {
        Intent hotel = new Intent(Intent.ACTION_VIEW);
        hotel.setData(Uri.parse("https://www.marriott.com/en-us/hotels/burap-los-angeles-marriott-burbank-airport/overview/"));
        startActivity(hotel);
    }

    /**
     * log into account
     * @param view log in
     */
    public void loginClick(View view) {
        Intent login = new Intent(this, LogIn.class);
        startActivity(login);
    }

}