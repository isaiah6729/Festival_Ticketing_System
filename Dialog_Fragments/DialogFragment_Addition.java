package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.ConfirmationPage;
import com.zybooks.testworldsalsa.R;

/** creates being added dialog
 *
 */
public class DialogFragment_Addition extends DialogFragment {

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("You have been added. Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Complete! Thank you!");
        builder.setPositiveButton("OK", null);
        return builder.create();

    }
}
