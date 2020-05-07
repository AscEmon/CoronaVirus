package com.example.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation top,bottom;
  TextView corona;
  ImageView ringer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        corona=findViewById(R.id.Corona);
        ringer=findViewById(R.id.Ringer);

        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        corona.setAnimation(top);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        ringer.setAnimation(bottom);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();


    }

    private void startApp() {

        Intent intent=new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void doWork() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
