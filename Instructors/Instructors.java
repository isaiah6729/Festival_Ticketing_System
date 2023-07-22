package Instructors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zybooks.testworldsalsa.R;

/** this shows all the instructors */
public class Instructors extends AppCompatActivity implements View.OnClickListener {

    Button bersyButton;
    ImageView bersyImage;
    TextView bersyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors);

        bersyButton = findViewById(R.id.bersyBookButton);
        bersyImage = findViewById(R.id.bersyPicture);
        bersyText = findViewById(R.id.bersyText);

        bersyButton.setOnClickListener(this);
        bersyImage.setOnClickListener(this);
        bersyText.setOnClickListener(this);
    }

    /**
     * go to bersy page
     */
    public void bersyClick()  {
        Intent bersyIntent = new Intent(this, Instructor___Bersy.class);
        startActivity(bersyIntent);
    }

    /**
     * bersy page
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bersyBookButton || v.getId() == R.id.bersyText || v.getId() == R.id.bersyPicture) {
            bersyClick();
        }
    }

    /**
     *  Instructor___Elena
     * @param view Instructor___Elena
     */
    public void elenaClick(View view) {
        Intent elenaIntent = new Intent(this, Instructor___Elena.class);
        startActivity(elenaIntent);
    }

    /**Instructor___Paulina
     *
     * @param view Instructor___Paulina
     */
    public void PaulinaClick(View view) {
        Intent paIntent = new Intent(this, Instructor___Paulina.class);
        startActivity(paIntent);
    }

    /**
     * Instructor___Fausto
     * @param view Instructor___Fausto
     */
    public void faustoClick(View view) {
        Intent faIntent = new Intent(this, Instructor___Fausto.class);
        startActivity(faIntent);
    }

    /**
     * Instructor___Maritza
     * @param view Instructor___Maritza
     */
    public void maritzaClick(View view) {
        Intent marIntent = new Intent(this, Instructor___Maritza.class);
        startActivity(marIntent);
    }

    /**
     * Instructor___Tito
     * @param view Instructor___Tito
     */
    public void titoClick(View view) {
        Intent titoIntent = new Intent(this, Instructor___Tito.class);
        startActivity(titoIntent);
    }

    /**
     * Instructor___Ana
     * @param view  Instructor___Ana
     */
    public void anaClick(View view) {
        Intent anaIntent = new Intent(this, Instructor___Ana.class);
        startActivity(anaIntent);
    }

    /** Instructor___Victor
     *
     * @param view Instructor___Victor
     */
    public void victorClick(View view) {
        Intent victorIntent = new Intent(this, Instructor___Victor.class);
        startActivity(victorIntent);
    }
}