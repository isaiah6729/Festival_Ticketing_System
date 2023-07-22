package com.zybooks.testworldsalsa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragments.FragmentPerformFriday;
import Fragments.FragmentPerformSaturday;
import Fragments.FragmentPerformSunday;

/** get the tab selections on performance page */
public class PerformancesAdapter extends FragmentStateAdapter {
    public PerformancesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * @param position selections
     * @return selections
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentPerformFriday();
            case 1:
                return new FragmentPerformSaturday();
            case 2:
                return new FragmentPerformSunday();
            default:
                return new FragmentPerformFriday();
        }
    }

    /**
     * @return number of tabs 3
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}
