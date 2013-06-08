package com.blogspot.turtldev.centipede;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PanelThread extends Thread {
    private SurfaceHolder   _surfaceHolder;
    private DrawingPanel    _panel;
    private boolean         _run = false;

    public PanelThread( SurfaceHolder surface_holder, DrawingPanel panel ) {
        _surfaceHolder = surface_holder;
        _panel = panel;
    }

    public void setRunning( boolean run ) {
        _run = run;
    }

    @Override
    public void run() {
        Canvas c;
        while (_run) {     //When setRunning(false) occurs, _run is
            c = null;      //set to false and loop ends, stopping thread

            try {
                c = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {
                    //Insert methods to modify positions of items in onDraw()
                    _panel.postInvalidate();
                }
            }
            finally {
                if (c != null) {
                    _surfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}
