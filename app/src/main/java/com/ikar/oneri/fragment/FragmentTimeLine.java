package com.ikar.oneri.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.ikar.oneri.R;
import com.ikar.oneri.adapter.ListOfTrendPagerAdapter;
import com.ikar.oneri.page_transformer.DepthPageTransformer;

/**
 * Created by mustafasevgi on 10/11/14.
 */
public class FragmentTimeLine extends BaseFragment {

    private ViewPager viewPager;
    private ListOfTrendPagerAdapter adapter;
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
        adapter = new ListOfTrendPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());
        this.viewPager = (ViewPager) view.findViewById(R.id.fragment_list_of_trend_viewpager);
        this.viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        PagerSlidingTabStrip mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.fragment_list_of_trend_tabstrip);
        mTabStrip.setViewPager(this.viewPager);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_time_line;
    }
}
