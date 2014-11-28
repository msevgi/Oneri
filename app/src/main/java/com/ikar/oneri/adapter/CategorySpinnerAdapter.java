package com.ikar.oneri.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ikar.oneri.R;
import com.ikar.oneri.application.OneriApplication;
import com.ikar.oneri.model.Category;

import java.util.List;

public class CategorySpinnerAdapter extends ArrayAdapter<Category> {
    public CategorySpinnerAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.spinner_item, parent, false);
        TextView row = (TextView) convertView.findViewById(R.id.textiew_spinner_item);
//        TextView row = (TextView) convertView;
        row.setText(getItem(position).getName());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
        return getView(position, cnvtView, prnt);
    }

    @Override
    public int getCount() {
        return OneriApplication.categoryList.size();
    }
}
