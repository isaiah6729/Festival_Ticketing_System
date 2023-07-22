package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DialogFragments.DialogFragment_Cart;
import DialogFragments.DialogFragment_LogIn_First;
import DialogFragments.DialogFragment_Tickets;

/** so you can tickets */
public class Tickets extends AppCompatActivity implements View.OnClickListener {

    private TextView numberoftickets;
    private TextView totalpriceoftickets;
    private TextView numberoftickets2;
    private TextView totalpriceoftickets2;
    private TextView numberoftickets3;
    private TextView totalpriceoftickets3;

    /** value and quantity of tickets */
    private int numberoftickets_value = 0;
    private int totalpriceoftickets_value ;
    private int numberoftickets_value2 = 0;
    private int totalpriceoftickets_value2 ;
    private int numberoftickets_value3 = 0;
    private int totalpriceoftickets_value3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        numberoftickets = findViewById(R.id.howmanyticketsdoyouwant);
        totalpriceoftickets = findViewById(R.id.totalpriceoftickets);
        numberoftickets2 = findViewById(R.id.howmanyticketsdoyouwant2);
        totalpriceoftickets2 = findViewById(R.id.totalpriceoftickets2);
        numberoftickets3 = findViewById(R.id.howmanyticketsdoyouwant3);
        totalpriceoftickets3 = findViewById(R.id.totalpriceoftickets3);


        Button button1 = findViewById(R.id.addSatBasicticketbutton);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.minusSaturdayBasicticketbutton);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.addFullEventticketbutton);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.minusFullEventticketbutton);
        button4.setOnClickListener(this);


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        numberoftickets_value = 0;
        numberoftickets_value2 = 0;
        numberoftickets_value3 = 0;
    }

    /** taking away a ticket
     *
     * @param view minus
     */
    public void minusclick(View view) {

        if  (numberoftickets_value == 0) {}

        else {
            numberoftickets_value = numberoftickets_value - 1;
            totalpriceoftickets_value = totalpriceoftickets_value - 158;
            numberoftickets.setText(String.valueOf(numberoftickets_value));
            totalpriceoftickets.setText(String.valueOf(totalpriceoftickets_value));
        }
    }

    /** adding a ticket
     *
     * @param view add
     */
    public void plusClick(View view) {
        numberoftickets_value = numberoftickets_value + 1;

            if (numberoftickets_value > 6) {
                DialogFragment_Tickets tix = new DialogFragment_Tickets();
                tix.show(getSupportFragmentManager(), "tix");
            } else {
                totalpriceoftickets_value = 158 * numberoftickets_value;
                numberoftickets.setText(String.valueOf(numberoftickets_value));
                totalpriceoftickets.setText(String.valueOf(totalpriceoftickets_value));
            }

    }

    /** multiple buttons on one clicker
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        /** add */
        if (v.getId() == R.id.addSatBasicticketbutton) {
            numberoftickets_value2 = numberoftickets_value2 + 1;


                if (numberoftickets_value2 > 10) {
                    DialogFragment_Tickets tix = new DialogFragment_Tickets();
                    tix.show(getSupportFragmentManager(), "tix");
                }
                else {
                    totalpriceoftickets_value2 = 86 * numberoftickets_value2;
                    numberoftickets2.setText(String.valueOf(numberoftickets_value2));
                    totalpriceoftickets2.setText(String.valueOf(totalpriceoftickets_value2));
                }

        }

        /** minus */
        else if (v.getId() == R.id.minusSaturdayBasicticketbutton) {

            if  (numberoftickets_value2 == 0) {}

            else {
                numberoftickets_value2 = numberoftickets_value2 - 1;
                totalpriceoftickets_value2 = totalpriceoftickets_value2 - 86;
                numberoftickets2.setText(String.valueOf(numberoftickets_value2));
                totalpriceoftickets2.setText(String.valueOf(totalpriceoftickets_value2));
            }
        }

        /** add */
       else if (v.getId() == R.id.addFullEventticketbutton) {
            numberoftickets_value3 = numberoftickets_value3 + 1;

                if (numberoftickets_value3 > 3) {
                DialogFragment_Tickets tix = new DialogFragment_Tickets();
                tix.show(getSupportFragmentManager(), "tix");
            }
                else {
                totalpriceoftickets_value3 = 260 * numberoftickets_value3;
                numberoftickets3.setText(String.valueOf(numberoftickets_value3));
                totalpriceoftickets3.setText(String.valueOf(totalpriceoftickets_value3));
                }
        }

        /** minus */
       else if (v.getId() == R.id.minusFullEventticketbutton) {


            if  (numberoftickets_value3 == 0) {}

            else {
                numberoftickets_value3 = numberoftickets_value3 - 1;
                totalpriceoftickets_value3 = totalpriceoftickets_value3 - 260;
            numberoftickets3.setText(String.valueOf(numberoftickets_value3));
            totalpriceoftickets3.setText(String.valueOf(totalpriceoftickets_value3));
            }
        }
    }

    /** saving a ticket
     *
     * @param view save
     */
    public void submitClick1(View view) {

        int type = 1;

            int quantity = Integer.parseInt(numberoftickets.getText().toString());

        if (quantity == 0 ) {
            DialogFragment_Cart cart = new DialogFragment_Cart();
            cart.show(getSupportFragmentManager(), "cart");
        }

        else {

            try {
                if (SalsaDataBase.getloggedin().getName() == null) {}

                else {
                    int total = Integer.parseInt(totalpriceoftickets.getText().toString());

                    Intent buy = new Intent(this, CheckOutPage.class);
                    buy.putExtra("quantity", quantity);
                    buy.putExtra("total", total);
                    buy.putExtra("type1", type);
                    startActivity(buy);
                }
            } catch (NullPointerException e) {

                DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                log.show(getSupportFragmentManager(), "log");
            }
        }
    }

    /** buying a ticket
     *
     * @param view ticket
     */
    public void submitClick2(View view) {

        int type = 2;

            int quantity = Integer.parseInt(numberoftickets2.getText().toString());

        if (quantity == 0 ) {
            DialogFragment_Cart cart = new DialogFragment_Cart();
            cart.show(getSupportFragmentManager(), "cart");
        }
            else {

                try {

            if (SalsaDataBase.getloggedin().getName() == null) {}

            else {

                int total = Integer.parseInt(totalpriceoftickets2.getText().toString());

                Intent buy = new Intent(this, CheckOutPage.class);
                buy.putExtra("quantity", quantity);
                buy.putExtra("total", total);
                buy.putExtra("type2", type);
                startActivity(buy);
            }
                } catch (NullPointerException e) {

                    DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                    log.show(getSupportFragmentManager(), "log");
                }
        }

    }

    /** buying a ticket
     *
     * @param view ticket
     */
    public void submitClick3(View view) {

        int type = 3;

            int quantity = Integer.parseInt(numberoftickets3.getText().toString());

            if (quantity == 0 ) {
                DialogFragment_Cart cart = new DialogFragment_Cart();
                cart.show(getSupportFragmentManager(), "cart");
            }

            else {

                try {

                if (SalsaDataBase.getloggedin().getName() == null) {}

                else {

                    int total = Integer.parseInt(totalpriceoftickets3.getText().toString());

                    Intent buy = new Intent(this, CheckOutPage.class);
                    buy.putExtra("quantity", quantity);
                    buy.putExtra("total", total);
                    buy.putExtra("type3", type);
                    startActivity(buy);
                }
                } catch (NullPointerException e) {

                    DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                    log.show(getSupportFragmentManager(), "log");
                }
            }
    }


}