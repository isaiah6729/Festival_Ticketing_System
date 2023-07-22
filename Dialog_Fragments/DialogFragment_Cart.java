package DialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.zybooks.testworldsalsa.R;

public class DialogFragment_Cart extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int draw = R.drawable.people;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Your cart is empty. \n Go searching or Buy a ticket. \n Thank you!");
        builder.setIcon(draw);
        builder.setTitle("Buy Something");
        builder.setPositiveButton("OK", null);
        return builder.create();
    }
}
