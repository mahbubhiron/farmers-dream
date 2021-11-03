package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScrennActivity extends AppCompatActivity {

    private int progress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screnn);

        progressBar = findViewById(R.id.progressbar_id);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }
    public void doWork(){
        for (progress=20;progress<=100;progress=progress+20)
        try {
            Thread.sleep(1200);
            progressBar.setProgress(progress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void startApp(){
        Intent intent = new Intent(SplashScrennActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}