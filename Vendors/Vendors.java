package Vendors;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.testworldsalsa.R;

/** lets you register as a vendor */
public class Vendors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendors);
    }

    /**
     * go to processing page
     * @param view leave
     */
    public void registervendorClick(View view) {
        Intent register = new Intent(this, VendorProcessing.class);
        startActivity(register);
    }

    /**
     * see the booths available
     * @param view booths
     */
    public void boothClick(View view) {
        Intent booth = new Intent(this, VendorBoothPicture.class);
        startActivity(booth);
    }
}