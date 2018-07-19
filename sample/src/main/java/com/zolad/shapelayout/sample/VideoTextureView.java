package com.zolad.shapelayout.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;


public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {


    private SurfaceHolder holder;
    private MediaPlayer mediaPlayer;
    Context context;
    private boolean loaded = false;

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = getContext();

        isHardwareAccelerated();
        this.mediaPlayer = new MediaPlayer();
        setSurfaceTextureListener(this);


    }

    public void setVideoURI(Uri uri) {


        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            loaded = true;
        } catch (Exception ex) {

        }
    }

    public void start() {


        if (loaded) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }


    }


    Surface s;

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if (this.mediaPlayer != null) {

            s = new Surface(surface);


            mediaPlayer.setSurface(s);


        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
