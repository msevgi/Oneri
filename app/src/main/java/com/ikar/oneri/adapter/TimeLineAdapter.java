package com.ikar.oneri.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ikar.oneri.R;

import java.util.List;

public class TimeLineAdapter extends ArrayAdapter<String> {

    public TimeLineAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.fragment_time_line_row, parent, false);
        return convertView;
    }

}
