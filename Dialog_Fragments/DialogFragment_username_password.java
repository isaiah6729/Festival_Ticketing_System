package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

public class DialogFragment_username_password extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Username or/and Password length to short or long. Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Limits Violated");
        builder.setPositiveButton("OK", null);
        return builder.create();
    }
}
