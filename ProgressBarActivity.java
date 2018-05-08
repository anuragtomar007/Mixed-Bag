package com.example.anurag.phonecallapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar androidProgressBar;
    int progressStatusCounter = 0;
    TextView textView;
    Handler progressHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        androidProgressBar = findViewById(R.id.horizontal_progress_bar);
        textView = findViewById(R.id.textView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatusCounter<100){
                    progressStatusCounter+=2;
                    progressHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            androidProgressBar.setProgress(progressStatusCounter);
                            textView.setText("Status "+ progressStatusCounter+"/"+androidProgressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
