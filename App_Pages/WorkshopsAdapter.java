package com.zybooks.testworldsalsa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragments.FragmentWorkshopFriday;
import Fragments.FragmentWorkshopSaturday;
import Fragments.FragmentWorkshopSunday;

/** adapter page for the workshops tabs */
public class WorkshopsAdapter extends FragmentStateAdapter {
    public WorkshopsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**works the fragments
     * @param position tabs
     * @return tabs
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentWorkshopFriday();
            case 1:
                return new FragmentWorkshopSaturday();
            case 2:
                return new FragmentWorkshopSunday();
            default:
                return new FragmentWorkshopFriday();
        }
    }

    /**gets count
     * @return tab count
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}
