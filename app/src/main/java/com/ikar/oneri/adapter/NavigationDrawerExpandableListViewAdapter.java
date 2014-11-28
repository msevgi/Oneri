package com.ikar.oneri.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ikar.oneri.R;
import com.ikar.oneri.application.OneriApplication;
import com.ikar.oneri.event.LeftGroupImageClickEvent;
import com.ikar.oneri.model.Category;
import com.ikar.oneri.provider.BusProvider;


public class NavigationDrawerExpandableListViewAdapter extends BaseExpandableListAdapter {

    private static ViewHolderGroup viewHolderGroup;
    private static ViewHolderChild viewHolderChild;
    private LayoutInflater layoutInflater;

    public NavigationDrawerExpandableListViewAdapter(Activity activity) {
        layoutInflater = (LayoutInflater.from(activity));
        //TODO fill the arraylist


    }

    @Override
    public int getGroupCount() {
        return OneriApplication.categoryList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return OneriApplication.categoryList.get(groupPosition).getChildList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.fragment_left_group_row, parent, false);
            viewHolderGroup = new ViewHolderGroup();
            viewHolderGroup.groupNameTextView = (TextView) convertView.findViewById(R.id.textview_left_group_name);
            viewHolderGroup.groupImageview = (ImageView) convertView.findViewById(R.id.imageview_left_plus);
            convertView.setTag(viewHolderGroup);
        } else {
            viewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }

        final Category item = OneriApplication.categoryList.get(groupPosition);
        if (item != null) {
            if (!isExpanded) {
                viewHolderGroup.groupImageview.setBackgroundResource(R.drawable.left_menu_plus);
            } else {
                viewHolderGroup.groupImageview.setBackgroundResource(R.drawable.left_menu_minus);
            }
            viewHolderGroup.groupImageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BusProvider.getInstance().post(new LeftGroupImageClickEvent(groupPosition));
                }
            });
            viewHolderGroup.groupNameTextView.setText(item.getName());
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.fragment_left_child_row, parent, false);
            viewHolderChild = new ViewHolderChild();
            viewHolderChild.childTextView = (TextView) convertView.findViewById(R.id.textview_child_row);
            convertView.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }
        Category item = OneriApplication.categoryList.get(groupPosition);
        if (item != null) {
            viewHolderChild.childTextView.setText(item.getChildList().get(childPosition));
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolderGroup {
        private ImageView groupImageview;
        private TextView groupNameTextView;
    }

    private class ViewHolderChild {
        private TextView childTextView;
    }
}
