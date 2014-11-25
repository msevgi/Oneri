package com.ikar.oneri.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ikar.oneri.R;
import com.ikar.oneri.event.ExtendedFirstButtonClickEvent;
import com.ikar.oneri.event.ExtendedSecondButtonClickEvent;
import com.ikar.oneri.provider.BusProvider;


public final class ExtendedImageView extends FrameLayout implements View.OnClickListener {
    private RelativeLayout mLinearLayout;
    private ImageButton imageButtonShareFB;
    private ImageButton imageButtonDetail;
    private ImageView mImageView;
    private static final float[] colorMatrix = {
            0.33f, 0.33f, 0.33f, 0, 5, //red
            0.33f, 0.33f, 0.33f, 0, 5, //green
            0.33f, 0.33f, 0.33f, 0, 5, //blue
            0, 0, 0, 1, 0    //alpha
    };

    private static final ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);

    public ExtendedImageView(Context context) {
        super(context);

        if (!isInEditMode())
            init();
    }

    public ExtendedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            init();
    }

    public ExtendedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            init();
    }

    private void init() {
        inflate(getContext(), R.layout.extended_imageview, this);

        mLinearLayout = (RelativeLayout) findViewById(R.id.linearlayout_cell);
        imageButtonShareFB = (ImageButton) findViewById(R.id.imagebutton_share_fb);
        imageButtonDetail = (ImageButton) findViewById(R.id.imagebutton_detail);
        mImageView = (ImageView) findViewById(R.id.imageview_cell);

        imageButtonShareFB.setOnClickListener(this);
        imageButtonDetail.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagebutton_share_fb:
                BusProvider.getInstance().post(new ExtendedFirstButtonClickEvent());
                return;
            case R.id.imagebutton_detail:
                BusProvider.getInstance().post(new ExtendedSecondButtonClickEvent());
                return;
            case R.id.imageview_cell:
                toggleButtons();
                return;
        }
    }

    private void toggleButtons() {
        if (mLinearLayout.getVisibility() == VISIBLE) {
            mLinearLayout.setVisibility(GONE);
            mImageView.setColorFilter(null);
        } else {
            mLinearLayout.setVisibility(VISIBLE);
            mImageView.setColorFilter(colorFilter);
        }
    }

    public void setImageResource(@DrawableRes Drawable drawableRes) {
        mImageView.setImageDrawable(drawableRes);
    }
}
