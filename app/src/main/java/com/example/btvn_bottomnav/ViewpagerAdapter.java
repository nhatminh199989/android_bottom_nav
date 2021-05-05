package com.example.btvn_bottomnav;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    /**
     * Constructor for {@link FragmentStatePagerAdapter}.
     * <p>
     * If {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT} is passed in, then only the current
     * Fragment is in the {@link Lifecycle.State#RESUMED} state, while all other fragments are
     * capped at {@link Lifecycle.State#STARTED}. If {@link #BEHAVIOR_SET_USER_VISIBLE_HINT} is
     * passed, all fragments are in the {@link Lifecycle.State#RESUMED} state and there will be
     * callbacks to {@link Fragment#setUserVisibleHint(boolean)}.
     *
     * @param fm       fragment manager that will interact with this adapter
     * @param behavior determines if only current fragments are in a resumed state
     */
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ListFragment();
            default:
                return new HomeFragment();

        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 2;
    }
}
