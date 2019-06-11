package com.example.CaseStudy.DriverRace;

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
public class ResultsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.results, R.string.practice, R.string.qualifying};
    private final Context mContext;

    public ResultsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

            switch(position) {
                case 0:
                    return ResultsFragment.newInstance();
                case 1:
                    return Practice.newInstance();
                case 2:
                    return Qualifying.newInstance();
                default:
                    return ResultsFragment.newInstance(); // shouldn't ever reach here
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
        // Show 3 total pages.
        return 3;
    }
}