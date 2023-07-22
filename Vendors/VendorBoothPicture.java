package Vendors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.testworldsalsa.R;

/** shows the booths available for purchase */
public class VendorBoothPicture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_booth_picture);
    }

    /**
     * register as vendor
     * @param view vendor
     */
    public void regvendorClick(View view) {
        Intent register = new Intent(this, VendorProcessing.class);
        startActivity(register);
    }
}