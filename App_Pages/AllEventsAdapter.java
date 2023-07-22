package com.zybooks.testworldsalsa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragments.FragmentEventsFriday;
import Fragments.FragmentEventsSaturday;
import Fragments.FragmentEventsSunday;
import Fragments.FragmentEventsThursday;

/** this class is the adapter for the tabs on the events page */
public class AllEventsAdapter extends FragmentStateAdapter {
    public AllEventsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * @param position tabs execution
     * @return tabs execution
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentEventsThursday();
            case 1:
                return new FragmentEventsFriday();
            case 2:
                return new FragmentEventsSaturday();
            case 3:
                return new FragmentEventsSunday();
            default:
                return new FragmentEventsFriday();
        }
    }

    /**
     * @return the count of the tabs
     */
    @Override
    public int getItemCount() {
        return 4;
    }
}
