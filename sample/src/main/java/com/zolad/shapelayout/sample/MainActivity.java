package com.zolad.shapelayout.sample;

import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zolad.shapelayout.ShapeLayout;
import com.zolad.shapelayout.shape.ClipPathShapeModel;
import com.zolad.shapelayout.shape.DrawableShapeModel;

public class MainActivity extends AppCompatActivity {

    VideoTextureView videoview1, videoview2;
    ShapeLayout shapeLayout1, shapeLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoview1 = findViewById(R.id.video_view);
        videoview2 = findViewById(R.id.video_view2);
        shapeLayout1 = findViewById(R.id.spl_v1);
        shapeLayout2 = findViewById(R.id.spl_v2);

        Drawable shapeDrawable = getResources().getDrawable(R.drawable.pic_drawable);
        shapeLayout1.setShapeModel(new DrawableShapeModel(shapeDrawable));


        shapeLayout2.setShapeModel(new ClipPathShapeModel(new ClipPathShapeModel.OnClipPath() {
            @Override
            public Path setClipPath(int w, int h) {

                int radio =  60;

                Path path = new Path();
                path.moveTo(0,radio/2);
                path.arcTo(new RectF(0,0,radio,radio),180,90);
                path.lineTo(w - radio/2-radio,0);
                path.arcTo(new RectF(w - radio*2, 0, w - radio, radio), -90, 90);
                path.lineTo(w-radio,h/2 -radio/2);
                path.lineTo(w,h/2);
                path.lineTo(w-radio,h/2 +radio/2);
                path.lineTo(w-radio,h - radio/2);
                path.arcTo(new RectF(w-radio*2, h-radio,w-radio,h-1),0,90);
                path.lineTo(radio/2,h-1);
                path.arcTo(new RectF(0,h-radio,radio,h-1),90,90);
                path.close();
                return path;
            }
        }));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample_video);
                videoview1.setVideoURI(uri);

                videoview1.start();


                videoview2.setVideoURI(uri);

                videoview2.start();
            }
        }, 1000);

    }
}
