package com.ikar.oneri.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.ikar.oneri.provider.BusProvider;
import com.squareup.otto.Bus;

/**
 * Created by mustafasevgi on 10/11/14.
 */
public abstract class BaseActionBarActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        getBus().register(this);
    }

    public abstract int getLayoutResource();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getBus().unregister(this);
    }

    protected Bus getBus() {
        return BusProvider.getInstance();
    }
}
