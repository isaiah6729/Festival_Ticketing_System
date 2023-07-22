package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import DialogFragments.DialogFragment_Addition;
import DialogFragments.DialogFragment_Cart;
import DialogFragments.DialogFragment_Tickets;

/** this class is for the check out page */
public class CheckOutPage extends AppCompatActivity {

    // list for using to get extras
    String[] instructors = {"elena", "ana", "bersy", "fausto", "tito", "elena1", "ana1", "fausto1", "bersy1", "tito1"};
    String[] types = {"type1", "type2", "type3"};

    SalsaDataBase dataBase;

    int quantity;
    int total;
    int workshop;
    int tickets;
    String name;
    String type;

    TextView textView;
    TextView textView2;
    ImageView imageView;

    /** gathering the extras to use to gather check out information
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_page);

        dataBase = new SalsaDataBase(this);

        textView = findViewById(R.id.mike);
        textView2 = findViewById(R.id.topText);
        imageView = findViewById(R.id.checkoutDrawable);

        /** workshop page information */
        for (int i = 0; i < instructors.length; ++i) {
            workshop = getIntent().getIntExtra(instructors[i], workshop);
            if (workshop > 0) {
                bookWorkshop();
            }
        }

        /**ticket page information */
        for (int i = 0; i < types.length; ++i) {
            tickets = getIntent().getIntExtra(types[i], tickets);
            if (tickets > 0) {
                bookTickets();
            }
        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        total = 0;
        quantity = 0;
        tickets = 0;

        textView2.setText("Your cart is now empty. \n Please purchase something");
        textView.setText("Your cart's empty \n but not for long \n Go searching or Buy a ticket. ");

    }


    /** get the tickets that you've purchased */
    private void bookTickets() {

         quantity = getIntent().getIntExtra("quantity", quantity);
         total = getIntent().getIntExtra("total", total);

        Cursor cursor = dataBase.readTicketType(tickets);
        while (cursor.moveToNext()) {
            name = cursor.getString(0);
        }
        cursor.close();

        /** assign image to cursor results*/
        if (tickets <= 3) {
            textView2.setText("Congratulations! \n You chose a " + name + " pass! \n You're this close to seeing Victor Manuelle");
            textView.setText("Your total is $" + total + " for " + quantity + " tickets");
            imageView.setImageResource(R.drawable.__victorcoming);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
    }


    /** get the workshops that you purchased */
    public void bookWorkshop() {

        //      for (int i = 0; i < instructors.length; ++i) {
        //  workshop = getIntent().getIntExtra(instructors[i], workshop);

        Cursor cursor = dataBase.readWorkshops(workshop);
        while (cursor.moveToNext()) {
            name = cursor.getString(0);
            type = cursor.getString(1);
        }
        cursor.close();
        //    }

        /** get the images of your purchase */
        if (workshop == 1) {
            textView.setText(name + "'s " + type + " on Friday");
            imageView.setImageResource(R.drawable.elena);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        } else if (workshop == 2 ) {
            textView.setText(name + "'s " + type + " on Friday");
            imageView.setImageResource(R.drawable.ana);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        } else if (workshop == 3) {
            textView.setText(name + "'s " + type + " on Friday");
            imageView.setImageResource(R.drawable.__fausto_flag);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 4) {
            textView.setText(name + "'s " + type + " on Friday");
            imageView.setImageResource(R.drawable.__bersycortez2);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 5) {
            textView.setText(name + "'s " + type + " on Friday");
            imageView.setImageResource(R.drawable.__tito_tamara1);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 6) {
            textView.setText(name + "'s " + type + " on Saturday");
            imageView.setImageResource(R.drawable.__bersycortez2);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 7) {
            textView.setText(name + "'s " + type + " on Saturday");
            imageView.setImageResource(R.drawable.ana);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 8) {
            textView.setText(name + "'s " + type + " on Saturday");
            imageView.setImageResource(R.drawable.__fausto_flag);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 9) {
            textView.setText(name + "'s " + type + " on Saturday");
            imageView.setImageResource(R.drawable.__bersycortez2);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 10) {
            textView.setText(name + "'s " + type + " on Saturday");
            imageView.setImageResource(R.drawable.__tito_tamara1);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 11) {
            textView.setText(name + "'s " + type + " on Sunday");
            imageView.setImageResource(R.drawable.elena);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 12) {
            textView.setText(name + "'s " + type + " on Sunday");
            imageView.setImageResource(R.drawable.ana);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 13) {
            textView.setText(name + "'s " + type + " on Sunday");
            imageView.setImageResource(R.drawable.__fausto_flag);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 14) {
            textView.setText(name + "'s " + type + " on Sunday");
            imageView.setImageResource(R.drawable.__bersycortez2);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }
        else if (workshop == 15) {
            textView.setText(name + "'s " + type + " on Sunday");
            imageView.setImageResource(R.drawable.a_titotamara);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(650);
            imageView.setMaxWidth(650);
        }

    }

    /** adds your purchase to the database
     *
     * @param view database
     */
    public void buyEverythingClick(View view) {

        /** add workshop to database */
        if (workshop > 0) {
            int userID = SalsaDataBase.getloggedin().getId();
            String usersname = SalsaDataBase.getloggedin().getName();
            String usersemail = SalsaDataBase.getloggedin().getEmail();

            /** databse */
            long db = dataBase.addworkshops(workshop, userID, usersname, usersemail, LocalDateTime.now(), LocalDateTime.now());

            if (db > 0) {

                Intent confirm = new Intent(this, ConfirmationPage.class);
                confirm.putExtra(name, workshop);
                startActivity(confirm);
            }

            else {
                DialogFragment_Cart cart = new DialogFragment_Cart();
                cart.show(getSupportFragmentManager(), "cart");
            }
        }

        /** add tickets to database */
        if (tickets > 0) {

            /** generic information */
            int userID = SalsaDataBase.getloggedin().getId();
            String usersname = SalsaDataBase.getloggedin().getName();
            String usersemail = SalsaDataBase.getloggedin().getEmail();

            /** DATABASE */
            long db = dataBase.addTickets(usersname, usersemail, userID, LocalDateTime.now(), tickets);

            if (db > 0) {

                Intent confirm = new Intent(this, ConfirmationPage.class);
                confirm.putExtra("type1", tickets);
                startActivity(confirm);
            }

            else {
                DialogFragment_Cart cart = new DialogFragment_Cart();
                cart.show(getSupportFragmentManager(), "cart");
            }
        }
    }



}