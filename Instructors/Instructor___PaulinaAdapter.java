package Instructors;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import Fragments.FragmentFriday;
import Fragments.FragmentSaturday;
import Fragments.FragmentSunday;

/** paulina's page adapter for tabs */
public class Instructor___PaulinaAdapter extends FragmentStateAdapter {
    public Instructor___PaulinaAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentFriday();
            case 1:
                return new FragmentSaturday();
            case 2:
                return new FragmentSunday();
            default:
                return new FragmentFriday();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
