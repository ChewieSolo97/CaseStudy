package com.example.CaseStudy.DriverProfile;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.CaseStudy.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.profile_tab, R.string.season_tab};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // this creates a fragment based on the position of what tab the user is on
        // I will need a if else to control which fragment is created here
        if (position == 0) {
            return ProfileFragment.newInstance(position);
        } else if (position == 1) {
            return DriverSeasonTab.newInstance();
        } else {
            // this should never happen, may change this later
            return new Fragment();
        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a ProfileFragment (defined as a static inner class below).
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}