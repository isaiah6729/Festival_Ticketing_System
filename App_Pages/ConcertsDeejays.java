package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * this page shows the concert artists
 */
public class ConcertsDeejays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concerts_deejays);
    }

    /** go to buy tickets page
     *
     * @param view tickets
     */
    public void bookTix(View view) {
        Intent book = new Intent(this, Tickets.class);
        startActivity(book);
    }


}