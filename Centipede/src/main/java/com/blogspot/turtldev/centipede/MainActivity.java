package com.blogspot.turtldev.centipede;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
    DrawingPanel draw_view;
    GestureDetector gesturedetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        draw_view = new DrawingPanel(this);
        draw_view.setBackgroundColor(Color.WHITE);
        setContentView(this.draw_view);

        gesturedetector = new GestureDetector(this, new MyGestureListener());

        draw_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gesturedetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        private static final int SWIPE_MIN_DISTANCE = 150;
        private static final int SWIPE_MAX_OFF_PATH = 100;
        private static final int SWIPE_THRESHOLD_VELOCITY = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            float dX = e2.getX()-e1.getX();
            float dY = e1.getY()-e2.getY();

            if (Math.abs(dY)<SWIPE_MAX_OFF_PATH &&
                    Math.abs(velocityX)>=SWIPE_THRESHOLD_VELOCITY &&
                    Math.abs(dX)>=SWIPE_MIN_DISTANCE ) {
                if (dX>0) {
                    draw_view.game.change_direction(Direction.EAST);
                    Log.v("motion","Right Swipe");
                }
                else {
                    draw_view.game.change_direction(Direction.WEST);
                    Log.v("motion","Left Swipe");
                }
                return true;
            }
            else if (Math.abs(dX)<SWIPE_MAX_OFF_PATH &&
                    Math.abs(velocityY)>=SWIPE_THRESHOLD_VELOCITY &&
                    Math.abs(dY)>=SWIPE_MIN_DISTANCE ) {
                if (dY>0) {
                    draw_view.game.change_direction(Direction.NORTH);
                    Log.v("motion","Up Swipe");
                }
                else {
                    draw_view.game.change_direction(Direction.SOUTH);
                    Log.v("motion","Down Swipe");
                }
                return true;
            }
            return false;
        }
    }
}

//TODO Main Menu
//TODO Failure Menu
//TODO Success Menu