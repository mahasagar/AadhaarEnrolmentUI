package com.mahasagar.aadhaarenrolmentui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by mahasagar on 22/5/16.
 */
public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ViewPager viewPager;
    Context context;
    public PagerAdapter( FragmentManager fm, int NumOfTabs, ViewPager viewPager) {
        super(fm);
//        this.context = context;
        this.mNumOfTabs = NumOfTabs;
        this.viewPager = viewPager;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment detailsFragment = TabFragmentPersonal.newInstance(viewPager);
                return detailsFragment;
            case 1:
                Fragment fragment_tab2 = TabFragmentUIDAI.newInstance(viewPager);
                return fragment_tab2;
            case 2:
                Fragment fragment_tab3 = TabFragmentVerification.newInstance(viewPager);
                return fragment_tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}