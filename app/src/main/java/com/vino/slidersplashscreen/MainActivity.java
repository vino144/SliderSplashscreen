package com.vino.slidersplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView splashImageView = (ImageView) findViewById(R.id.SplashImageView);
        splashImageView.setBackgroundResource(R.drawable.splash);
        final AnimationDrawable frameAnimation = (AnimationDrawable)splashImageView.getBackground();
        Thread timer= new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent splash =new Intent(MainActivity.this,HomeScreen.class);
                    startActivity(splash);
                }
            }
        };
        timer.start();
        splashImageView.post(frameAnimation::start);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}