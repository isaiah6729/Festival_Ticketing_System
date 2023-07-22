package com.zybooks.testworldsalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/** this page confirms your purchases  */
public class ConfirmationPage extends AppCompatActivity {

    /** lists to bring your purchases */
    String[] instructors = {"Elena La Candela", "Ana Rodriguez", "Fausto Felix", "Bersy Cortez", "Tito y Tamara"};
    String[] types = {"type1", "type2", "type3"};
    String[] competitions = {"proAm"};
    String[] kids = {"kids"};

    int competition;
    int kidsCompetition;
    int workshop;
    int tickets;

    TextView textView;
    ImageView imageView;

    /**gets intent and shows your purchases
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        textView = findViewById(R.id.mike);
        imageView = findViewById(R.id.checkoutDrawable);

        /** confirm workhshop */
        for (int i = 0; i < instructors.length; ++i) {
            workshop = getIntent().getIntExtra(instructors[i], workshop);
            if (workshop > 0) {
                /** get the images of your purchase */
                if (workshop == 1) {
                    imageView.setImageResource(R.drawable.elena);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                } else if (workshop == 2 ) {

                    imageView.setImageResource(R.drawable.ana);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                } else if (workshop == 3) {

                    imageView.setImageResource(R.drawable.__fausto_flag);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 4) {

                    imageView.setImageResource(R.drawable.__bersycortez2);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 5) {

                    imageView.setImageResource(R.drawable.__tito_tamara1);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 6) {

                    imageView.setImageResource(R.drawable.__bersycortez2);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 7) {

                    imageView.setImageResource(R.drawable.ana);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 8) {

                    imageView.setImageResource(R.drawable.__fausto_flag);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 9) {

                    imageView.setImageResource(R.drawable.__bersycortez2);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 10) {

                    imageView.setImageResource(R.drawable.__tito_tamara1);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 11) {

                    imageView.setImageResource(R.drawable.elena);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 12) {

                    imageView.setImageResource(R.drawable.ana);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 13) {

                    imageView.setImageResource(R.drawable.__fausto_flag);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 14) {

                    imageView.setImageResource(R.drawable.__bersycortez2);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
                else if (workshop == 15) {

                    imageView.setImageResource(R.drawable.a_titotamara);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
            }
        }

        /** confirm tickets */
        for (int i = 0; i < types.length; ++i) {
            tickets = getIntent().getIntExtra(types[i], tickets);
            if (tickets > 0) {
                if (tickets <= 5) {
                    imageView.setImageResource(R.drawable.__victormanuelle);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
            }
        }

        /** confirm competitions */
        for (int i = 0; i < competitions.length; ++i) {
            competition = getIntent().getIntExtra(competitions[i], competition);
            if (competition > 0) {
                if (competition < 10) {
                    imageView.setImageResource(R.drawable.__competition);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
            }
        }

        /** confirm kids competition */
        for (int i = 0; i < kids.length; ++i) {
            kidsCompetition = getIntent().getIntExtra(kids[i], kidsCompetition);
            if (kidsCompetition > 0) {
                if (kidsCompetition <= 5) {
                    imageView.setImageResource(R.drawable.__kids);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(650);
                    imageView.setMaxWidth(650);
                }
            }
        }
    }

    /**
     * go to home page
     * @param view homepage
     */
    public void homeClick(View view) {
        Intent leave = new Intent(this, HomePage.class);
        startActivity(leave);
    }

    /**go to workshop
     *
     * @param view workshop
     */
    public void WorkshopClick(View view) {
        Intent leave = new Intent(this, Workshops.class);
        startActivity(leave);
    }

    /**
     * go to tickets
     * @param view tickets
     */
    public void ticketsClick(View view) {
        Intent leave = new Intent(this, Tickets.class);
        startActivity(leave);
    }
}