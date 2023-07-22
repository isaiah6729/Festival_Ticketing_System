package DialogFragments;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.zybooks.testworldsalsa.R;

/** tells you that you'll be contacted */
public class DialogFragment_Contacted extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("You will be contacted soon. \nYou can go back to the Home Page. \nThank you!");
        builder.setIcon(draw);
        builder.setTitle("Complete! Thank you!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * @param dialog the dialog that received the click
             * @param which  the button that was clicked (ex.
             *               {@link DialogInterface#BUTTON_POSITIVE}) or the position
             *               of the item clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();

  }
}