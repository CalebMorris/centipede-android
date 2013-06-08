package com.blogspot.turtldev.centipede;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback {
    PanelThread _thread;
    Game game;

    public DrawingPanel( Context context ) {
        super(context);
        getHolder().addCallback(this);
    }

    public void onSizeChanged( int w, int h, int oldw, int oldh ) {
        game = new Game( this, w, h );
        game.init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        //TODO implement on_draw

        game.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()

        _thread = new PanelThread(getHolder(), this); //Start the thread that
        _thread.setRunning(true);                     //will make calls to
        _thread.start();                              //onDraw()

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        try{
            _thread.setRunning(false);
            _thread.join();
        }
        catch (InterruptedException e) {}
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //TODO implement surface_change
    }

}