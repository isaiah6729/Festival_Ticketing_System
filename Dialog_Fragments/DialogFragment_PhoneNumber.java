package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

public class DialogFragment_PhoneNumber extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Phone Number cannot be less than \n 10 numbers. Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Invalid Phone Number");
        builder.setPositiveButton("OK", null);
        return builder.create();
    }
}
