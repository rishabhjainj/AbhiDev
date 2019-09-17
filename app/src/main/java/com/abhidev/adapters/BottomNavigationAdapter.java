package com.abhidev.adapters;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.ViewGroup;

import com.abhidev.Fragments.ExploreFragment;
import com.abhidev.Fragments.HomeFragment;


import java.util.ArrayList;

/**
 * Created by Rishabh on 2/14/2018.
 */

public class BottomNavigationAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>();

    private Fragment currentFragment;

    Context context;
    public BottomNavigationAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context= context;
        fragments.clear();
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(ExploreFragment.newInstance(1));
        //fragments.add(ProfileBottomFragment.newInstance(2));

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {

            if (getCurrentFragment() != object) {
                currentFragment = ((Fragment) object);

            }
            super.setPrimaryItem(container, position, object);

    }


    /**
     * Get the current fragment
     */
    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}