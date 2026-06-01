package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private TextView mTextView;
    private ProgressBar mProgressBar;

    public SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = tv;
        mProgressBar = pb;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int n = random.nextInt(11);
        int sleepTime = n * 200;

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for "
                + sleepTime
                + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.setText(result);
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
    }
}