package com.belatrixsf.mobiledevfundamentals17;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentTimeActivity extends AppCompatActivity {

    public final static String TAG_LOG = CurrentTimeActivity.class.getSimpleName(); //this is just "CurrentTimeActivity"

    private EditText timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_time);

        // initializing UI views that will be used later
        timeEditText = (EditText) findViewById(R.id.timeEditText);

        // log needed by exercise #2
        Log.d(TAG_LOG, "OnCreate");
    }

    public void buttonClicked(View v) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma", Locale.US);
        String dateToShow = sdf.format(d);
        timeEditText.setText(dateToShow);
    }

    @Override protected void onStart() {
        super.onStart();

        // log needed by exercise #2
        Log.d(TAG_LOG, "onStart");
    }

    @Override protected void onResume() {
        super.onResume();

        // log needed by exercise #2
        Log.d(TAG_LOG, "onResume");
    }

    @Override protected void onPause() {
        super.onPause();

        // log needed by exercise #2
        Log.d(TAG_LOG, "onPause");
    }

    @Override protected void onStop() {
        super.onStop();

        // log needed by exercise #2
        Log.d(TAG_LOG, "onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();

        // log needed by exercise #2
        Log.d(TAG_LOG, "onDestroy");
    }

}
