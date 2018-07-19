package com.zolad.shapelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.zolad.shapelayout.shape.ShapeModel;

/**
 * Custom shaped layout for Android
 * */
public class ShapeLayout extends FrameLayout {

    private ShapeModel mShapeModel;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ShapeLayout(@NonNull Context context) {
        this(context, null);
    }

    public ShapeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
    }

    public void setShapeModel(ShapeModel shapeModel) {
        this.mShapeModel = shapeModel;
        postInvalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {


        super.dispatchDraw(canvas);

        if (mShapeModel != null) {

            mShapeModel.clipCanvas(canvas, mPaint);

            // No Available In HardWare Layout
            setLayerType(LAYER_TYPE_HARDWARE, null);
        }




    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(changed)
            postInvalidate();
    }
}
