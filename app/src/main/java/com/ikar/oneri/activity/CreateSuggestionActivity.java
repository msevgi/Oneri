package com.ikar.oneri.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ikar.oneri.R;

public class CreateSuggestionActivity extends BaseActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar= (Toolbar) findViewById(R.id.activity_create_suggestion_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_create_suggestion;
    }
}
