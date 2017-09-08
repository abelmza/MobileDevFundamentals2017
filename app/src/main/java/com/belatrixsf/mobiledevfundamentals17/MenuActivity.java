package com.belatrixsf.mobiledevfundamentals17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void exercise1ButtonClicked(View v) {
        Intent i = new Intent(this, CurrentTimeActivity.class);
        startActivity(i);
    }

    public void exercise5ButtonClicked(View v) {
        Intent i = new Intent(this, ImageActivity.class);
        startActivity(i);
    }

    public void exercise6ButtonClicked(View v) {
        Intent i = new Intent(this, TimerActivity.class);
        startActivity(i);
    }
}
