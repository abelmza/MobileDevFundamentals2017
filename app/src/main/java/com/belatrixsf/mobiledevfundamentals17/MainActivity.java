package com.belatrixsf.mobiledevfundamentals17;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public final static String TAG_LOG = MainActivity.class.getSimpleName(); //this is just "MainActivity"

    private EditText timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG_LOG, "Initializing activity...");
        setContentView(R.layout.activity_main);
        timeEditText = findViewById(R.id.timeEditText);
    }

    public void buttonClicked(View v) {
        Log.d(TAG_LOG, "Button clicked");
        Date d = new Date();
        Log.d(TAG_LOG, "Date before formatting: " + d.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mma");
        String dateToShow = sdf.format(d);
        Log.d(TAG_LOG, "Formatted time: " + dateToShow);
        timeEditText.setText(dateToShow);
    }
}
