package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/** opens hotel page */
public class Hotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
    }

    /** goes to hotel website
     *
     * @param view hotel
     */
    public void hotelClick(View view) {
        Intent hotel = new Intent(Intent.ACTION_VIEW);
        hotel.setData(Uri.parse("https://www.marriott.com/en-us/hotels/burap-los-angeles-marriott-burbank-airport/overview/"));
        startActivity(hotel);
    }
}