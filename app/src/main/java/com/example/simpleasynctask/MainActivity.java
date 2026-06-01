package com.example.simpleasynctask;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        mProgressBar = findViewById(R.id.progressBar);
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        mProgressBar.setVisibility(View.VISIBLE);

        new SimpleAsyncTask(mTextView, mProgressBar).execute();
    }
}