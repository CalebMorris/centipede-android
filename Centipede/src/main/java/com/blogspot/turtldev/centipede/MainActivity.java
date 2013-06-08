package com.blogspot.turtldev.centipede;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
    DrawingPanel draw_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        draw_view = new DrawingPanel(this);
        draw_view.setBackgroundColor(Color.WHITE);
        setContentView(this.draw_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

//TODO Main Menu
//TODO Failure Menu
//TODO Success Menu