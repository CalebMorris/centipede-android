package com.blogspot.turtldev.centipede;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by cdbitesky on 6/10/13.
 */
public class SettingsActivity extends Activity {
    EditText speed;
    EditText size;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        speed = (EditText)findViewById(R.id.editText_speed);
        size = (EditText)findViewById(R.id.editText_size);

        size.setText("16");
        speed.setText("100");
    }

    public void onAcceptClick( View view ) {
        // Gather new information from edit_texts, if within bounds return the data
        int message_speed = Integer.parseInt(speed.getText().toString());
        int message_size = Integer.parseInt(size.getText().toString());
        Intent intentMessage = new Intent();

        intentMessage.putExtra("SIZE",message_size);
        intentMessage.putExtra("SPEED",message_speed);
        setResult(2, intentMessage);

        finish();
    }

    public void onCancelClick( View view ) {
        // Return nothing and finish the activity
        finish();
    }
}