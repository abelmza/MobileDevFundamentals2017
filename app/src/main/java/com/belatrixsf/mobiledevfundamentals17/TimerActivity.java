package com.belatrixsf.mobiledevfundamentals17;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private final static String TAG = TimerActivity.class.getSimpleName();

    private TextView timerTextView;
    private TextView asyncTimerTextView;

    private boolean continueThread = false;
    private Timer timer;

    private AsyncTimer asyncTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        asyncTimerTextView = (TextView) findViewById(R.id.asyncTimerTextView);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// Metodos y clases para timer que usa java.lang.Thread
    ///
    public void onStartButtonClicked(View v) {
        if (timer == null) { //previene inicializar 2 veces el timer.
            continueThread = true;
            timer = new Timer();
            timer.start();
        }
    }

    public void onStopButtonClicked(View v) {
        continueThread = false;
        timer.interrupt();
        timer = null;
    }

    void updateThreadTimer(int seconds) {
        timerTextView.setText(seconds + " segundos");
    }

    class Timer extends Thread {
        int seconds = 0;

        @Override public void run() {
            super.run();
            while (continueThread) {
                seconds++;
                runOnUiThread(new Runnable() {
                    @Override public void run() {
                        updateThreadTimer(seconds);
                    }
                });
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Ooops: " + e);
                }
            }

            runOnUiThread(new Runnable() {
                @Override public void run() {
                    updateThreadTimer(0);
                }
            });
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// Metodos y clases para timer que usa AsyncTask
    ///
    public void onAsyncStartButtonClicked(View v) {
        if (asyncTimer == null) { // previene inicializar 2 veces el timer
            asyncTimer = new AsyncTimer();
            asyncTimer.execute();
        }
    }

    public void onAsyncStopButtonClicked(View v) {
        asyncTimer.cancel(true);
        updateAsyncTimer(0);
        asyncTimer = null;
    }

    void updateAsyncTimer(int seconds) {
        asyncTimerTextView.setText(seconds + " segundos");
    }



    class AsyncTimer extends AsyncTask<Void, Integer, Void> {

        int timer = 0;

        @Override protected Void doInBackground(Void... params) {

            while (true) {
                timer++;
                publishProgress(timer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Ooops: " + e);
                }
                if (isCancelled()) {
                    break;
                }
            }
            return null;
        }

        @Override protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateAsyncTimer(values[0]);
        }
    }


}
