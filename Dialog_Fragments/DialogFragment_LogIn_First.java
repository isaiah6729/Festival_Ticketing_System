package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

import ProfilePages.LogIn;

public class DialogFragment_LogIn_First extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("You must log in to make a purchase. \n Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Not Logged In!");
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Go to Log In", new DialogInterface.OnClickListener() {
            /**
             * @param dialog the dialog that received the click
             * @param which  the button that was clicked (ex.
             *               {@link DialogInterface#BUTTON_POSITIVE}) or the position
             *               of the item clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent go = new Intent(getContext(), LogIn.class);
                startActivity(go);
            }
        });
        return builder.create();
    }
}
