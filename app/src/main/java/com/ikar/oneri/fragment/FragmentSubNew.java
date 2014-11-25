package com.ikar.oneri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;
import com.ikar.oneri.R;
import com.ikar.oneri.activity.CreateSuggestionActivity;
import com.ikar.oneri.adapter.SubTimeLineAdapter;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

public class FragmentSubNew extends BaseFragment implements View.OnClickListener, PullRefreshLayout.OnRefreshListener {

    public final static int POSITION = 0;
    private PullRefreshLayout pullRefreshLayout;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private ListView listView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        pullRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
//        floatingActionButton.attachToRecyclerView(recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView = (ListView) view.findViewById(R.id.listview);
        floatingActionButton.setOnClickListener(this);
        floatingActionButton.attachToListView(listView);
        listView.setAdapter(new SubTimeLineAdapter(getActivity(), 0, new ArrayList<String>()));
//        recyclerView.setAdapter(new TimeLineAdapter(new ArrayList<String>()));
//
        pullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);


        pullRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), CreateSuggestionActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), floatingActionButton, "create_suggestion");

        ActivityCompat.startActivity(getActivity(), intent, activityOptionsCompat.toBundle());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sub_time_line;
    }

    @Override
    public void onRefresh() {
        pullRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullRefreshLayout.setRefreshing(false);
            }
        }, 4000);
    }
}
