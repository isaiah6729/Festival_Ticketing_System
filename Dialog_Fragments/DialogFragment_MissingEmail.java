package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

public class DialogFragment_MissingEmail extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Your missing an @ or . (period)  Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Invalid Email");
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
