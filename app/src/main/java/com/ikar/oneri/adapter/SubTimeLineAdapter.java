package com.ikar.oneri.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ikar.oneri.R;
import com.ikar.oneri.view.ExtendedImageView;

import java.util.List;

/**
 * Created by mustafasevgi on 24/11/14.
 */
public class SubTimeLineAdapter extends ArrayAdapter<String> {
    public SubTimeLineAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.fragment_sub_time_line_row, parent, false);
        ExtendedImageView extendedImageView= (ExtendedImageView) convertView.findViewById(R.id.imageview_item);
        extendedImageView.setImageResource(getContext().getResources().getDrawable(R.drawable.kitap1));
        return convertView;
    }

    @Override
    public int getCount() {
        return 50;
    }
}
