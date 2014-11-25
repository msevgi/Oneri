package com.ikar.oneri.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.ikar.oneri.R;
import com.ikar.oneri.adapter.NavigationDrawerExpandableListViewAdapter;
import com.ikar.oneri.event.LeftGroupImageClickEvent;
import com.ikar.oneri.fragment.FragmentTimeLine;
import com.squareup.otto.Subscribe;


public class MainActivity extends BaseActionBarActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener {
    public static String title;
    private static int previousPosition = 0;
    private ExpandableListView drawerListView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Fragment fragment = null;
    private LinearLayout linearLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        title = getString(R.string.app_name);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        drawerListView = (ExpandableListView) findViewById(R.id.left_drawer_list);
        drawerListView.setGroupIndicator(null);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationDrawerExpandableListViewAdapter adapter = new NavigationDrawerExpandableListViewAdapter(this);
        drawerListView.setAdapter(adapter);
        drawerListView.setOnGroupClickListener(this);
        drawerListView.setOnChildClickListener(this);
        fragment = new FragmentTimeLine();
        setDrawerLayout(0, 0);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                R.drawable.ic_drawer, /* nav drawer icon to replace 'Up' caret */
                R.string.navigation_drawer_open, /* "open drawer" description */
                R.string.navigation_drawer_close /* "close drawer" description */
        );

        // Set actionBarDrawerToggle as the DrawerListener
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        // just styling option add shadow the right edge of the drawer
        // drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.layout_main;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setDrawerLayout(int groupPosition, int childPosition) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            // update selected item and title, then close the drawer
            drawerListView.setSelectedGroup(groupPosition);
            if (childPosition != -1)
                drawerListView.setSelectedChild(groupPosition, childPosition, true);
            toolbar.setTitle(title);
        }
        drawerLayout.closeDrawer(linearLayout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // call ActionBarDrawerToggle.onOptionsItemSelected(), if it returns true
        // then it has handled the app icon touch event
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // swipe edilince app icon yanndaki simgenin degismesini sagliyor
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        switch (groupPosition) {
            case 0:
                title = "Kitap";
                fragment = new FragmentTimeLine();
                Bundle args = new Bundle();
                args.putInt("groupPosition", groupPosition);
                args.putInt("groupPosition", -1);
                fragment.setArguments(args);
                break;
            default:
                break;
        }
        setDrawerLayout(groupPosition, -1);
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        switch (childPosition) {
            case 0:
                title = "Roman";
                fragment = new FragmentTimeLine();
                Bundle args = new Bundle();
                args.putInt("groupPosition", groupPosition);
                args.putInt("groupPosition", childPosition);
                fragment.setArguments(args);
                break;
            default:
                break;
        }
        setDrawerLayout(groupPosition, childPosition);
        return false;
    }

    @Subscribe
    public void onGroupIconClick(LeftGroupImageClickEvent leftGroupImageClickEvent) {
        int position = leftGroupImageClickEvent.getGroupPosition();
        if (!drawerListView.isGroupExpanded(position)) {
            drawerListView.collapseGroup(previousPosition);
            drawerListView.expandGroup(position, true);
        } else
            drawerListView.collapseGroup(position);
        previousPosition = position;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}