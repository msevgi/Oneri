package com.ikar.oneri.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ikar.oneri.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder> {
    private ArrayList<String> arrayList;


    public TimeLineAdapter(ArrayList<String> list) {
        this.arrayList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(viewGroup.getContext(), android.R.layout.simple_expandable_list_item_1, viewGroup));
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textViewTitle.setText("Kurk Mantolu Madonna");
    }


    @Override
    public int getItemCount() {
        return 50;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewTitle;
        private TextView textViewDate;
        private TextView textViewUserName;
        private TextView textViewLikeCount;
        private ImageView imageViewSuggestion;
        private ImageButton imageButtonLike;
        private ImageButton imageButtonComment;
        private CircleImageView circleImageViewProfile;

        public ViewHolder(View itemView) {
            super(itemView);
textViewTitle= (TextView) itemView;
//            textViewTitle = (TextView) itemView.findViewById(R.id.textview_title);
//            textViewDate = (TextView) itemView.findViewById(R.id.textview_date);
//            textViewUserName = (TextView) itemView.findViewById(R.id.textview_username);
//            textViewLikeCount = (TextView) itemView.findViewById(R.id.textview_like_count);
//            imageViewSuggestion = (ImageView) itemView.findViewById(R.id.imageview_item);
//            imageButtonComment = (ImageButton) itemView.findViewById(R.id.imagebutton_comment);
//            imageButtonLike = (ImageButton) itemView.findViewById(R.id.imagebutton_like);
//            circleImageViewProfile = (CircleImageView) itemView.findViewById(R.id.imageview_user_photo);
        }
    }
}
