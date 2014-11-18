package com.ikar.oneri.activity;

import android.os.Bundle;

import com.ikar.oneri.R;

public class CreateSuggestionActivity extends BaseActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_suggestion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
