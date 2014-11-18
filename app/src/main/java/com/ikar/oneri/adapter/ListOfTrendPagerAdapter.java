package com.ikar.oneri.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ikar.oneri.R;
import com.ikar.oneri.fragment.FragmentSubBestOf;
import com.ikar.oneri.fragment.FragmentSubNew;
import com.ikar.oneri.fragment.FragmentSubTrend;

/**
 * Created by mustafasevgi on 16/11/14.
 */
public class ListOfTrendPagerAdapter extends FragmentPagerAdapter {

    private String[] titleArray;

    public ListOfTrendPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        titleArray = context.getResources().getStringArray(R.array.sub_fragment_time_line_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FragmentSubNew.POSITION:
                return new FragmentSubNew();
            case FragmentSubTrend.POSITION:
                return new FragmentSubTrend();
            case FragmentSubBestOf.POSITION:
                return new FragmentSubBestOf();
            default:
                throw new IllegalArgumentException("Unknown position.");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }
}
