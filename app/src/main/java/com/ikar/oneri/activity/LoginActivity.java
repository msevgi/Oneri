package com.ikar.oneri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ikar.oneri.R;

/**
 * Created by mustafasevgi on 10/11/14.
 */
public class LoginActivity extends BaseActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView_skip = (TextView) findViewById(R.id.textview_skip);
        textView_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayoutResource() {
        return R.layout.login;
    }
}
