package com.zolad.shapelayout.shape;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;

public class DrawableShapeModel implements ShapeModel {

    private Drawable mDrawable;
    private Canvas mCanvas;

    private PorterDuffXfermode pdMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    public DrawableShapeModel(Drawable drawable){
        this.mDrawable = drawable;

    }

    @Override
    public void clipCanvas(Canvas canvas, Paint paint) {


        if(mDrawable == null)
            return;


        paint.setXfermode(pdMode);

        Bitmap clipBitmap =  Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);

        if(mCanvas == null) {
           mCanvas = new Canvas(clipBitmap);

        }else {

            mCanvas.setBitmap(clipBitmap);

        }

        mDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        mDrawable.draw(mCanvas);

        canvas.drawBitmap(clipBitmap, 0, 0, paint);

        paint.setXfermode(null);


    }
}
