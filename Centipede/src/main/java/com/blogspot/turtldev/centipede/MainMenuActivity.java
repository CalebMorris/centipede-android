package com.blogspot.turtldev.centipede;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by cdbitesky on 6/8/13.
 */
public class MainMenuActivity extends Activity {
    int size = 16;
    int speed = 100;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        intent.putExtra("size", size);
        intent.putExtra("speed", speed);

        startActivity(intent);
    }

    public void onSettingsClick( View view ) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (2) : {
                //if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    if( data != null ) {
                        int message = data.getIntExtra("SPEED", 16);
                        speed = message;
                        Log.v("result","size:"+message);
                        message = data.getIntExtra("SIZE", 100);
                        size = message;
                        Log.v("result","speed:"+message);
                    }
                    else {
                        Log.v("result","Settings haven't been changed");
                    }
                //}
                break;
            }
        }
    }

    //TODO Settings Activity && Settings button intent
}