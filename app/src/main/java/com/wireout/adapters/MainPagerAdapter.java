package com.wireout.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rishabh on 2/10/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;
    String[] tabText = {"Home","Explore","Career News","Events"};
    public static final String TAG = MainPagerAdapter.class.getSimpleName();

    public List<Fragment> fragmentList=new ArrayList<>();
    public List<String> titleList=new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    public void addFragment(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        titleList.add(title);
    }

    @Override
    public void destroyItem(View collection, int position, Object o) {
        View view = (View)o;
        ((ViewPager) collection).removeView(view);
        view = null;

    }

    @Override
    public String getPageTitle(int position) {
        return tabText[position];
    }

    @Override
    public Fragment getItem(int position) {

        Log.d(TAG, "getItem called.");
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
