package com.ikar.oneri.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ikar.oneri.R;
import com.ikar.oneri.event_model.ExtendedFirstButtonClickEvent;
import com.ikar.oneri.event_model.ExtendedSecondButtonClickEvent;
import com.ikar.oneri.provider.BusProvider;


public final class ExtendedImageView extends FrameLayout implements View.OnClickListener {
    private LinearLayout mLinearLayout;
    private Button mButton1;
    private Button mButton2;
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
        inflate(getContext(), R.layout.cell_extended_imageview, this);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearlayout_cell);
        mButton1 = (Button) findViewById(R.id.button1_cell);
        mButton2 = (Button) findViewById(R.id.button2_cell);
        mImageView = (ImageView) findViewById(R.id.imageview_cell);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1_cell:
                BusProvider.getInstance().post(new ExtendedFirstButtonClickEvent());
                return;
            case R.id.button2_cell:
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

    public void setImageResource(@DrawableRes int drawableRes) {
        mImageView.setImageResource(drawableRes);
    }

}
