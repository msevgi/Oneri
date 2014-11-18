package com.ikar.oneri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ikar.oneri.R;
import com.ikar.oneri.activity.CreateSuggestionActivity;
import com.melnykov.fab.FloatingActionButton;

/**
 * Created by mustafasevgi on 16/11/14.
 */
public class FragmentSubTrend extends BaseFragment implements View.OnClickListener {

    public final static int POSITION = 1;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), CreateSuggestionActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sub_time_line;
    }
}
