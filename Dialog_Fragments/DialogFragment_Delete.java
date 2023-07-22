package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

/** tells you that information was deleted */
public class DialogFragment_Delete extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

    int draw = R.drawable.people;

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Work deleted. Thank you.");
        builder.setIcon(draw);
        builder.setTitle("Delete!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * @param dialog the dialog that received the click
             * @param which  the button that was clicked (ex.
             *               {@link DialogInterface#BUTTON_POSITIVE}) or the position
             *               of the item clicked
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        return builder.create();
    }
}