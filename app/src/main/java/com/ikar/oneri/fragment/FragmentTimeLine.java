package com.ikar.oneri.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.ikar.oneri.R;
import com.ikar.oneri.adapter.ListOfTrendPagerAdapter;

/**
 * Created by mustafasevgi on 10/11/14.
 */
public class FragmentTimeLine extends BaseFragment {

    private ViewPager mViewPager;
    private ListOfTrendPagerAdapter mAdapter;
    private int groupPosition;
    private int childPosition;

    public FragmentTimeLine() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            groupPosition = bundle.getInt("groupPosition", -1);
            childPosition = bundle.getInt("childPosition", -1);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new ListOfTrendPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_list_of_trend_viewpager);
        mViewPager.setAdapter(mAdapter);

        PagerSlidingTabStrip mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.fragment_list_of_trend_tabstrip);
        mTabStrip.setViewPager(mViewPager);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_time_line;
    }
}
