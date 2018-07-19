package com.zolad.shapelayout.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

public class ClipPathShapeModel implements ShapeModel {

    private Path mPath;

    private OnClipPath mOnClipPath;

    private PorterDuffXfermode pdMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    public ClipPathShapeModel(OnClipPath onClipPath) {
        this.mOnClipPath = onClipPath;

    }

    @Override
    public void clipCanvas(Canvas canvas, Paint paint) {

        if (mOnClipPath == null)
            return;

        mPath = mOnClipPath.setClipPath(canvas.getWidth(), canvas.getHeight());

        if (mPath == null)
            return;

        paint.setXfermode(pdMode);

        canvas.drawPath(mPath, paint);

        paint.setXfermode(null);


    }

    public interface OnClipPath {


        Path setClipPath(int canvasWidth, int canvasHeight);


    }
}
