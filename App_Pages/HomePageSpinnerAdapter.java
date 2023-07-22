package com.zybooks.testworldsalsa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/** this creates the adapter to be used with the custom spinner homepagespinner */
public class HomePageSpinnerAdapter extends ArrayAdapter<HomePageSpinner> {

    public HomePageSpinnerAdapter(@NonNull Context context, ArrayList<HomePageSpinner> homePageSpinners) {
        super(context, 0, homePageSpinners);
    }

    /**
     * @param position    index of the item whose view we want.
     * @param convertView the old view to reuse, if possible. Note: You should
     *                    check that this view is non-null and of an appropriate type before
     *                    using. If it is not possible to convert this view to display the
     *                    correct data, this method can create a new view.
     * @param parent      the parent that this view will eventually be attached to
     * @return
     */
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initialize(position, convertView, parent);
    }

    /**
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initialize(position, convertView, parent);
    }

    /**
     *  initializing the text and image to be used
     * @param position initializing
     * @param convertView initializing
     * @param parent initializing
     * @return initializing
     */
    private View initialize (int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customspinner, parent, false);
    }
        ImageView imageView = convertView.findViewById(R.id.customimageView);
        TextView textView = convertView.findViewById(R.id.customtextView);

        HomePageSpinner homepageSpinner = getItem(position);

        if (homepageSpinner != null) {
            imageView.setImageResource(homepageSpinner.getPicture());
            textView.setText(homepageSpinner.getName());
        }
        return convertView;
    }


}
